/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.home_bookkeeping.dao;

import java.util.List;
import ua.com.codefire.home_bookkeeping.dao.models.Doc;

/**
 *
 * @author Igor Gayvan
 */
public interface IDocDao {

    List<Doc> getAll();

    List<Doc> getByDocNote(String docNote);

    Doc getByDocId(int id);

    void add(Doc doc);

    void remove(int id);

    void edit(Doc doc);
}
