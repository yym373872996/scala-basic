package person.rulo.scala.basic.c03_class

object s11_InnerClasses {

  def main(args: Array[String]): Unit = {
    // 在scala中，内部类是绑定到外部对象的
    // 以下是一个图的简单实现
    class Graph {
      class Node {
        var connectedNodes: List[Node] = Nil
        def connectTo(node: Node): Unit = {
          if (!connectedNodes.exists(node.equals)) {
            connectedNodes = node :: connectedNodes
          }
        }
      }
      var nodes: List[Node] = Nil
      def newNode: Node = {
        val res = new Node
        nodes = res :: nodes
        res
      }
    }
    // 会发现，用Graph对象创建出的node对象，其类型是绑定在Graph对象下的
    val graph1: Graph = new Graph
    val node1: graph1.Node = graph1.newNode
    val node2: graph1.Node = graph1.newNode
    val node3: graph1.Node = graph1.newNode
    node1.connectTo(node2)
    node3.connectTo(node1)
    // 如果试图连接两个graph对象下的node，由于其类型不一致会报错
    // 而这种情况在java中并不会出现
    val graph2: Graph = new Graph
    val node4: graph2.Node = graph2.newNode
//    node1.connectTo(node4)      // illegal!
    // 如果希望不区分类型，需要更改成如下
    class GraphNew {
      class Node {
        var connectedNodes: List[GraphNew#Node] = Nil
        def connectTo(node: GraphNew#Node): Unit = {
          if (!connectedNodes.exists(node.equals)) {
            connectedNodes = node :: connectedNodes
          }
        }
      }
      var nodes: List[Node] = Nil
      def newNode: Node = {
        val res = new Node
        nodes = res :: nodes
        res
      }
    }
    val graphNew1 = new GraphNew
    val nodeNew1: graphNew1.Node = graphNew1.newNode
    val graphNew2 = new GraphNew
    val nodeNew2: graphNew2.Node = graphNew2.newNode
    // 尽管类型路径不一致，仍然可以当做相同类型来处理
    nodeNew1.connectTo(nodeNew2)
  }

}
