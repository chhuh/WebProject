package web.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyCrawler {
	
	public static void main(String[] args) throws Exception {
        String url="http://localhost:8080/Seoul_19_BackEnd_허설_허창현/HouseDeal.xml";
        Document doc=Jsoup.connect(url).get();
        //Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
        Elements item=doc.select("item");
        for(int i=0;i<item.size();i++) {
            String dong=item.get(i).select("dong").text();            
            String aptName=item.get(i).select("aptName").text();            
            String code=item.get(i).select("code").text();            
            String dealAmount=item.get(i).select("dealAmount").text();            
            String buildYear=item.get(i).select("buildYear").text();            
            String dealYear=item.get(i).select("dealYear").text();            
            String dealMonth=item.get(i).select("dealMonth").text();            
            String dealDay=item.get(i).select("dealDay").text();            
            String area=item.get(i).select("area").text();            
            String floor=item.get(i).select("floor").text();            
            String lat=item.get(i).select("lat").text();            
            String lng=item.get(i).select("lng").text();            
            String jibun=item.get(i).select("jibun").text();            
            //String type=item.get(i).select("type").text();            
            //String rentMoney=item.get(i).select("rentMoney").text();
            
            System.out.printf("%s ,%s ,%s, %s ,%s ,%s ,%s ,%s ,%s ,%s, %s, %s, %s  \n",
                    dong, aptName,code,dealAmount, buildYear, dealYear
                    ,dealMonth,dealDay,area,floor,lat,lng,jibun);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HappyHouse", "ssafy", "12345");
            PreparedStatement stmt=con.prepareStatement("insert into HouseDeal(dong, aptName,code,dealAmount, buildYear, dealYear\r\n" + 
                    "                    ,dealMonth,dealDay,area,floor,lat,lng,jibun) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, dong);
            stmt.setString(2, aptName);
            stmt.setInt(3, Integer.parseInt(code));
            stmt.setString(4, dealAmount);
            stmt.setInt(5, Integer.parseInt(buildYear));
            stmt.setInt(6, Integer.parseInt(dealYear));
            stmt.setInt(7, Integer.parseInt(dealMonth));
            stmt.setInt(8, Integer.parseInt(dealDay));
            stmt.setDouble(9, Double.parseDouble(area));
            stmt.setInt(10, Integer.parseInt(floor));
            stmt.setString(11, lat);
            stmt.setString(12, lng);
            stmt.setString(13, jibun);
            
            stmt.executeUpdate();
        }
    }

}
