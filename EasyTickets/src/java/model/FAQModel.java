/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.event;
import entity.faq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dattr_000
 */
public class FAQModel {

    private ResultSet rs;
    private List<faq> listfaq = new ArrayList<>();

    public List<faq> getFAQ() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from FAQ");
            rs = ps.executeQuery();
            while (rs.next()) {
                listfaq.add(new faq(rs.getInt("id"),rs.getString("question"),rs.getString("answer")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listfaq;
    }
}
