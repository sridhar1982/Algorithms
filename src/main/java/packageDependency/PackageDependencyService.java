package packageDependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * resolve dependencies of package installation.
 * four operations supported. list, depend, install and remove
 * Ranking is determined similar to Topological sort method during install which goes Depth first to a node
 * without any child dependencies and installs it.
 */
public class PackageDependencyService {

    //key is string, value is packagenNode. for O(1) lookup;
    public Map<String, PackageNode> map = new HashMap();
    //O(1) look up to see if a package is installed
    public Set<PackageNode> installedPackages = new HashSet<>();
    //since LIST commands requires output to be in order installed, we store them here
    public List<PackageNode> installedPackagesInOrder = new ArrayList<>();
    //This set keeps explicitlyInstalledPackages so they are not implicitly removed during REMOVE command
    public Set<PackageNode> explicitlyInstalledPackages = new HashSet<>();



    public void depend(String parent, List<String> children) {
        List<PackageNode> childrenNodes = getOrCreateChildrenNodes(children);

        PackageNode p = null;
        if (map.containsKey(parent)) {
            p = map.get(parent);
        }
        else {
            p = new PackageNode(parent);
        }
        //throw any circular references
        for (PackageNode pn : childrenNodes) {
            if (p.getParents().contains(pn)) {
                System.out.println(pn + " depends on " + p + ", ignoring command");
                return;
            }
        }
        p.addChildrenAndParent(childrenNodes);
        map.put(parent, p);
    }

    public void list() {
        for (PackageNode p : installedPackagesInOrder){
            System.out.println(p);
        }
    }

    public void install(String name){
        if (installedPackages.contains(map.get(name))) {
            System.out.println(name + " is already installed");
            return;
        }
        installHelper(name);
        explicitlyInstalledPackages.add(map.get(name));

    }

    private void installHelper(String name){
        PackageNode toInstall = null;
        if (map.containsKey(name)) {
            if (installedPackages.contains(map.get(name))) {
                //System.out.println( name + " is already installed");
                return;
            }
            toInstall = map.get(name);
            for (PackageNode p : toInstall.getChildren()) {
                installHelper(p.getName());
            }
        }
        else {
            toInstall = new PackageNode(name);
        }
        System.out.println("Installing " + name);
        installedPackages.add(toInstall);
        installedPackagesInOrder.add(toInstall);
    }

    public void remove(String name) {
        if (map.containsKey(name) && installedPackages.contains(map.get(name))) {
            PackageNode toRemove = map.get(name);
            if (toRemove.getParents().size() > 0) {
                System.out.println(name + " is still needed");
            } else {
                removeHelper(toRemove);
                for (int i = 0; i<=installedPackagesInOrder.size() - 1; i++) {
                    PackageNode p = installedPackagesInOrder.get(i);
                    if (!explicitlyInstalledPackages.contains(p) && toRemove.getChildren().contains(p)) {
                        removeHelper(p);
                    }
                }
            }
        }  else {
            System.out.println(name + " is not installed");
        }
    }


    private void removeHelper(PackageNode nodeTobeRemoved) {
        if (nodeTobeRemoved.getParents().size() == 0) {
            nodeTobeRemoved.getChildren().stream()
                    .forEach(d ->
                            d.removeParent(nodeTobeRemoved)
                    );
            installedPackages.remove(nodeTobeRemoved);
            installedPackagesInOrder.remove(nodeTobeRemoved);
            explicitlyInstalledPackages.remove(nodeTobeRemoved);
            System.out.println("Removing " + nodeTobeRemoved);
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
}
