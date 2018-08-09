package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * this question was asked in salesforce hackerRank interview
 * reoslve dependenics of package. four operations supported. list, depend, install and remove
 */
public class PackageDependency {


    public static void main(String[] args) {
        PackageDependency pd = new PackageDependency();
        pd.depend("A", Arrays.asList("B","C"));
        pd.depend("B", Arrays.asList("C"));
        pd.depend("C", Arrays.asList("A"));
        pd.depend("C", Arrays.asList("D"));
        pd.install("A");
        pd.list();
        pd.remove("D");
        pd.remove("C");
        pd.remove("A");
        pd.remove("C");
        pd.remove("B");
        pd.remove("C");
        pd.list();

        pd.install("A");
        pd.list();

    }

    public Map<String, PackageNode> map = new HashMap();
    public Set<PackageNode> installedPackages = new HashSet<>();

    public void depend(String parent, List<String> children) {
        List<PackageNode> childdrenNodes = getOrCreateChildrenNodes(children);

        PackageNode p = null;
        if (map.containsKey(parent)) {
            p = map.get(parent);
        }
        else {
            p = new PackageNode(parent);
        }
        //throw any circular references
        for (PackageNode pn : childdrenNodes) {
            if (p.parents.contains(pn)) {
                System.out.println(pn + " depends on " + p + "; so cannot be depend");
                return;
            }
        }
        p.addChildrenAndParent(childdrenNodes);
        map.put(parent, p);
    }

    public void list() {
        System.out.println(installedPackages);
    }

    public void install(String name){
        if (!map.containsKey(name)) {
            System.out.println(name + " package cannot be installed without depend command");
            return;
        }
        if (installedPackages.contains(map.get(name))) {
            //System.out.println( name + " package already installed");
            return;
        }
        PackageNode toInstall = map.get(name);

        for (PackageNode p : toInstall.getChildren()) {
             install(p.getName());
        }
        System.out.println("installing " + name);
        installedPackages.add(toInstall);
    }


    public void remove(String name) {
        if (map.containsKey(name) && installedPackages.contains(map.get(name))) {
            PackageNode toRemove = map.get(name);
            if (toRemove.parents.size() == 0) {
                toRemove.getChildren().stream()
                        .forEach(d ->
                          d.removeParent(toRemove)
                        );
                installedPackages.remove(toRemove);
                System.out.println(name + " package removed");
            }
            else {
                System.out.println(name + " package cannot be removed");
            }
        }
    }

    private List<PackageNode> getOrCreateChildrenNodes(List<String> children) {

        List<PackageNode> childNodes = new ArrayList<>();
        for (String s : children) {
            if (map.containsKey(s)) {
                childNodes.add(map.get(s));
            }
            else {
                PackageNode p = new PackageNode(s);
                map.put(s, p);
                childNodes.add(p);
            }
        }
        return childNodes;
    }


    enum Operations {
        LIST,
        DEPEND,
        INSTALL,
        REMOVE;
    }

    public

    class PackageNode {
          //one way depdendency if A -> B, then A is associated with B and not other way
         private String name;
         private Set<PackageNode> children;
         private Set<PackageNode> parents;


         public PackageNode(String name) {
             this.name = name;
             this.children = new HashSet<>();
             this.parents = new HashSet<>();
         }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public Set<PackageNode> getChildren() {
            return children;
        }

        public void setChildren(Set<PackageNode> children) {
            this.children.addAll(children);
        }

        public void addChild(PackageNode packageNode) {
             this.children.add(packageNode);
        }

        public void addChildrenAndParent(List<PackageNode> packageNodes) {
            this.children.addAll(packageNodes);
            packageNodes.stream().forEach(e -> e.addParent(this));
        }

        public void addParent(PackageNode packageNode) {
             this.parents.add(packageNode);
        }

        public void removeParent(PackageNode packageNode) {
             this.parents.remove(packageNode);
        }

        public String toString(){
             return this.getName();
        }
    }
}
