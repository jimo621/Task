package hzw.main;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class RmiService {
    public static void main(String args[]){
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("服务端RMI8888启动");
    }
}
