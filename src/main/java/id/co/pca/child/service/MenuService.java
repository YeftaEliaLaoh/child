package id.co.pca.child.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.co.pca.child.model.Menu;
import id.co.pca.child.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    List<Menu> menuList;

    public List<Menu> getAllMenu() throws JsonProcessingException {
        menuList = menuRepository.findAll(Sort.by("parentId").ascending());
        //System.out.println(menuList);
        return getCategoryTree(menuList);
    }

    private List<Menu> getCategoryTree(List<Menu> listofnodes) throws JsonProcessingException {
        List<Menu> listofroots = new ArrayList<>();
        for (Menu menu : listofnodes) {
            if (menu.getParentId() == 0) {
                listofroots.add(menu);
            }
        }
        for (Menu menu : listofroots) {
            if (menu.getParentId() == 0) {
                menu.setChildren(getchildren(menu.getId(), listofnodes));
            }
        }
        return listofroots;
    }

    /*private void getCategoryTree() {

        Map<Menu, List<Menu>> map = new HashMap<>();

        menuList.forEach(node -> {
            //get parent category of current's SelectItem item =
            map.get(menuList.stream()
                    .filter(n -> n.getId()
                            == (node.getParentId())).findFirst().orElse(null));

        });
        System.out.println(map);
    }*/

/*    public void getCategoryTree(List menu) {
        var items = [];
        for (let cat of menu) {
            if (cat.parent_id === parent) {
      const children = getCategoryTree(cat.id);

                items.push({
                        id: cat.id,
                        title: cat.title,
                        children: children,
      });
            }
        }

        return items;
    }*/

    // console.log(getCategoryTree());


    public static List<Menu> getchildren(int nodeID, List<Menu> listofnodes) {
        List<Menu> childrenList = new ArrayList<>();

        for (Menu menu : listofnodes) {
            if (menu.getParentId() == nodeID) {
                menu.setChildren(getchildren(menu.getId(), listofnodes));
                childrenList.add(menu);
            }
        }
        return childrenList;
    }
}
