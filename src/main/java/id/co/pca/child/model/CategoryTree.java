/*
package id.co.pca.child.model;

import java.util.TreeMap;

public class CategoryTree<S, C> {
    private String name     = null;
    private String id       = null;

    private CategoryTree<String, CategoryTree<S, C>> children = new TreeMap<String, CategoryTree<S, C>>();


    public CategoryTree() {
    }

    public CategoryTree(String name, String id) {
        setName(name);
        setId(id);
    }

    public TreeMap<String, CategoryTree<S, C>> getChildren() {
        return this.children;
    }

    public CategoryTree<S, C> getChild(String childId) {
        return this.children.get(childId);
    }

    public void setChild(CategoryTree<S, C> child) {
        this.children.put(child.getId(), child);
    }

    public boolean hasChild(String childId) {
        TreeMap<String, CategoryTree<S, C>> set = this.children;
        boolean result =  set.containsKey(childId);
        return result;
    }
}
*/
