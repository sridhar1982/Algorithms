package packageDependency;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<PackageNode> getParents() {
        return parents;
    }

    public void setParents(Set<PackageNode> parents) {
        this.parents = parents;
    }
}
