import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseXML {
    public  String filePath;
    public Document document;
    public ParseXML(String filePath){
        this.filePath=filePath;
    }
    public void load(String filePath){
        File file=new File(filePath);
        if(file.exists()){
            SAXReader saxReader=new SAXReader();
            try{
                document=saxReader.read(file);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    public Element getElementObject(String elementPath){
        return  (Element) document.selectSingleNode(elementPath);
    }

    public List<Element> getElementObjects(String elementPath){
        return  document.selectNodes(elementPath);
    }
    public Map<String,String> getChildrenInfoByElement(Element element){
        Map<String,String> map=new HashMap<String, String>();
        List<Element> children=element.elements();
        for(Element e:children){
            map.put(e.getName(),e.getText());
        }
        return  map;
    }

    public Boolean isExist(String elementPath){
        boolean flag=false;
        Element element=this.getElementObject(elementPath);
        if (element!=null){
            flag=true;
        }
        return flag;
    }

    public String getElementText(String elementPath){
        Element element=this.getElementObject(elementPath);
        if (element!=null){
          return   element.getText().trim();
        }else {
            return null;
        }

    }

    public static void  main(String[] args){
        ParseXML px=new ParseXML("config/TestBaidu.xml");
        List<Element> elements=px.getElementObjects("/*/testUI");
        Object[][] object=new Object[elements.size()][];
        for(int i=0;i<elements.size();i++){
            Object[] temp=new Object[]{px.getChildrenInfoByElement(elements.get(i))};
            object[i]=temp;
        }
    }

}
