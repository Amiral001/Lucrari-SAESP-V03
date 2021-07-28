package com.nicholas.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ReplaceTextInPdf {

        public static void test1 () throws IOException {
            PDDocument document = null;
            document = PDDocument.load(new File("C:\\Users\\danal\\eclipse-workspace\\LucrariSAESP\\src\\main\\java\\com\\nicholas\\saesp\\templates\\UTAI.pdf"));
            document = replaceText(document, "lucrarea", "cu orice altceva ce e mai lung ca si numar de caractere");
            document.save("C:\\Users\\danal\\eclipse-workspace\\LucrariSAESP\\src\\main\\java\\com\\nicholas\\saesp\\templates\\UTAI2.pdf");
            document.close();
        }

        private static PDDocument replaceText(PDDocument document, String searchString, String replacement) throws IOException {
            if (StringUtils.isEmpty(searchString) || StringUtils.isEmpty(replacement)) {
                return document;
            }

            for (PDPage page : document.getPages()) {
                PDFStreamParser parser = new PDFStreamParser(page);
                parser.parse();
                List<?> tokens = parser.getTokens();

                for (int j = 0; j < tokens.size(); j++) {
                    Object next = tokens.get(j);
                    if (next instanceof Operator) {
                        Operator op = (Operator) next;

                        String pstring = "";
                        int prej = 0;

                        if (op.getName().equals("Tj")) {
                            COSString previous = (COSString) tokens.get(j - 1);
                            String string = previous.getString();
                            string = string.replaceFirst(searchString, replacement);
                            previous.setValue(string.getBytes());
                        } else if (op.getName().equals("TJ")) {
                            COSArray previous = (COSArray) tokens.get(j - 1);
                            for (int k = 0; k < previous.size(); k++) {
                                Object arrElement = previous.getObject(k);
                                if (arrElement instanceof COSString) {
                                    COSString cosString = (COSString) arrElement;
                                    String string = cosString.getString();

                                    if (j == prej) {
                                        pstring += string;
                                    } else {
                                        prej = j;
                                        pstring = string;
                                    }
                                }
                            }

                            if (searchString.equals(pstring.trim())) {
                                COSString cosString2 = (COSString) previous.getObject(0);
                                cosString2.setValue(replacement.getBytes());

                                int total = previous.size() - 1;
                                for (int k = total; k > 0; k--) {
                                    previous.remove(k);
                                }
                            }
                        }
                    }
                }
                PDStream updatedStream = new PDStream(document);
                OutputStream out = updatedStream.createOutputStream(COSName.FLATE_DECODE);
                ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
                tokenWriter.writeTokens(tokens);
                out.close();
                page.setContents(updatedStream);
            }

            return document;
        }

}
