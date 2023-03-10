package id.co.pca.child.dto;

import id.co.pca.child.model.Menu;

import java.util.LinkedList;
import java.util.HashMap;

public class MenuTree{
    private HashMap<Integer, MenuNode> menuMap;

    public void addNode(MenuNode node) {
        MenuNode parent = menuMap.get(node.getParent());
        if (parent != null) {
            parent.addChild(node);
        }
    }

    public void parse(LinkedList<Menu> input) {
        for (Menu entry : input) {
            MenuNode node = new MenuNode(entry.id, entry.menuName);
            MenuNode parent = menuMap.get(entry.parentId);
            if (parent != null) {
                parent.addChild(node);
            }
            menuMap.put(node.getId(), node);
        }
    }
}