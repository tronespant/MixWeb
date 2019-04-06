package com.room.mixweb.xml;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.parsing.XPathParser;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.SecurityPermission;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 19:152019/4/4
 * @Modificd By:
 * @At : MixWeb
 */
@Log4j
public class BaseXpathTest {

   static DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();

    private static DocumentBuilder documentBuilder=getDocumentBuilder();

    static {
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);
    }
    public static DocumentBuilder getDocumentBuilder(){
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
    public static void setErrorHandler(){
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                log.warn("warning:"+exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                log.error("error:"+exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                log.error("fatalerror:"+exception.getMessage());
            }
        });
    }
    @Test
    public void test(){
        try {
            Class cla=Class.forName("com.room.mixweb.MybatisTest");
            Method[] methods = cla.getDeclaredMethods();
            for (Method method:methods){
                StringBuffer sb=new StringBuffer();
                Class<?> returnType = method.getReturnType();
                if (returnType!=null){
                    sb.append(returnType.getName()).append("#");
                }
                sb.append(method.getName());
                Class<?>[] paramererTypes = method.getParameterTypes();
                for (int i=0;i<paramererTypes.length;i++){
                    if (i==0){
                        sb.append(":");
                    }else {
                        sb.append(",");
                    }
                    sb.append(paramererTypes[i].getName());
                }
                System.out.println(sb.toString());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo(){
        try {
            SecurityPermission sp=new SecurityPermission("test");
            Package pack = this.getClass().getPackage();
            String name = pack.getName();
            String url = this.getClass().getClassLoader().getResource("book.xml").getPath();
            Document doc = documentBuilder.parse(url);
            XPathFactory xpf=XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            XPathExpression expression=xpath.compile("//book[author='Dong']/title/text()");
            Object result = expression.evaluate(doc, XPathConstants.NODESET);
            System.out.println("查询作者为Dong的图书的标题：");
            NodeList nodes = (NodeList) result;
            documentBuilder.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    return null;
                }
            });
            for (int i=0;i<nodes.getLength();i++){
                System.out.println(nodes.item(i).getNodeValue());

            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}
