package id.co.pca.child.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

@Entity
@Table(name = "menu")
@Data
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public String menuName;
    public int parentId;
    @Transient
    private List<Menu> children;

}
