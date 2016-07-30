package com.ll.vo;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.lang.reflect.Field;  
  
import org.apache.commons.lang.StringUtils;  
  
  
/** 
* @author Administrator 
* 
*/  
public class VoUtils {  
public VoUtils(){}  
  
//����java���������ͷ���vo����  
public static String getClassType(Class c){  
   String typeName = c.getSimpleName();  
    
   if (typeName.equals("String") || typeName.equals("Date") || typeName.equals("Boolean")) {  
    return typeName;  
   }else if (typeName.equals("BigDecimal") || typeName.equals("Decimal") ||  
      typeName.equals("Double")) {  
    return "Number";  
   }else if (typeName.equals("Integer")) {  
    return "int";  
   }else {  
    return "*";//�������͵�����Ϊδ֪����,�˴����Լ�ȥ�������ƣ���������ʹ��"*"  
   }  
     
}  
//�ظ�c�ַ�count�Σ����ڸ�ʽ�����ɵ�as�ļ�  
public static String repeat(String c, int count){  
   String temp = "";  
   for(int i = 0;i<count ;i++){  
    temp += c;  
   }  
    
   return temp;  
}  
/** 
* ����as�ļ� 
* @param pojoName java�������� 
* @param packageName flex��vo����İ��� 
* @throws ClassNotFoundException 
* @throws IOException 
*/  
public static void generateAsFile(String pojoName, String packageName, String folder)  
    throws ClassNotFoundException, IOException {  
   Class c = Class.forName(pojoName);  
   Field[] fields =c.getDeclaredFields();  
    
   //as��vo�������ƽ�β����VO��־  
   // File f = new File(folder+c.getSimpleName()+"VO.as");  
   File f = new File(folder+c.getSimpleName()+".as");  
   BufferedWriter bw = new BufferedWriter(  
           new FileWriter(f));  
   //������û�����ð�����ȡ��java pojoһ���İ���  
   if (StringUtils.isEmpty(packageName)){  
    bw.write("package "+c.getPackage().getName()+"\n{\n");  
   }else{  
    bw.write("package "+packageName+"\n{\n");  
   }  
    
   //д��  
   bw.write(repeat(" ",4)+"public class "+c.getSimpleName()+"VO\n");  
   bw.write(repeat(" ",4)+"{\n");  
    
   //д����  
   for(int i=0;i<fields.length;i++){  
    Class fieldType = fields[i].getType();  
    String typeName = getClassType(fieldType);  
    bw.write(repeat(" ",8)+"private var _"+fields[i].getName()+":"+typeName+";\n");  
   }  
    
   bw.write("\n\n\n");  
   //д�յĹ��캯��  
   bw.write(repeat(" ",8)+"public function "+c.getSimpleName()+"VO(){}\n\n");  
    
   //д setter/getter ����  
   for(int i=0;i<fields.length;i++){  
    Class fieldType = fields[i].getType();  
    String typeName = getClassType(fieldType);  
    //setter  
    bw.write(repeat(" ",8)+"public function set "+fields[i].getName()+"(value:"+typeName+"):void{\n");  
    bw.write(repeat(" ",12)+"this._"+fields[i].getName()+" = value;\n");  
    bw.write(repeat(" ",8)+"}\n\n");  
    //getter  
    bw.write(repeat(" ",8)+"public function get "+fields[i].getName()+"():"+typeName+"{\n");  
    bw.write(repeat(" ",12)+"return this._"+fields[i].getName()+";\n");  
    bw.write(repeat(" ",8)+"}\n\n\n");  
     
   }  
   bw.write(repeat(" ",4)+"}\n");  
   bw.write("}");  
   bw.close();    
}  
  
//���ԣ�д�˸�����  
public static void main(String[] args) throws ClassNotFoundException, IOException {  
   // TODO Auto-generated method stub  
   String[] pojos = {  
     "com.ll.vo.CardInfoVO" 
     };  
   for(int i=0;i<pojos.length;i++){  
    //Class c = Class.forName(pojos[i]);  
    //System.out.println("registerClassAlias('"+pojos[i]+"',com.nstar.orderexpress.vo."+c.getSimpleName()+"VO);");  
    VoUtils.generateAsFile(pojos[i],"com.ll.vo.CardInfoVO","C:/temp/");  
   }  
    
}  
  
}  
