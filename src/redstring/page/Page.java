package redstring.page;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSourceGraphML.GraphMLConstants.Key;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class Page {
	
   protected static String styleSheet =
	    "node {" +
	    "	fill-color: black;" +
	    "}" +
	    "node.user {" +
	    "	fill-color: red;" +
	    "}" +
	    "edge {" +
	    "	fill-color: black;" +
	    "}" +
	    "edge.user {" +
	    "	fill-color: red;" +
	    "   stroke-color: red;" +
	    "}";

	/** Graph that represents the entire page */
	private static Graph pageGraph;
	
	 private static Viewer viewer;
     private static ViewerPipe viewerPipe;
	
	public static void showGraph( Graph g ) {
		g.display();
		viewerPipe = viewer.newViewerPipe();
        viewerPipe.addSink(g);
        viewerPipe.addViewerListener(new ViewerListener());
	}
	
	private static void newPage( String title ) {
		System.setProperty("org.graphstream.ui", "swing"); 
		pageGraph = new DefaultGraph( title );
		pageGraph.setAttribute("ui.quality");
		pageGraph.setAttribute("ui.antialias");
		pageGraph.setAttribute("ui.stylesheet", styleSheet);
		showGraph( pageGraph );
	}
	
	public static void main( String args[] ) {
		newPage( "Title" );
		pageGraph.addNode( "A" ).setAttribute("ui.label", "A");
		pageGraph.addNode( "E" );
		pageGraph.addNode( "D" );
		pageGraph.addEdge( "AD", "A", "D" ).setAttribute("ui.class", "user");
	}
	
//	private static class ViewerListener implements org.graphstream.ui.view.ViewerListener {
//        public void viewClosed(String id) {
//            System.exit(0);
//        }
//
//        public void buttonPushed(String id) {
//        }
//
//        public void buttonReleased(String id) {
//        }
//
//        public void keyPressed() {
//        	Key
//        }
//
//        public void keyReleased(org.graphstream.ui.view.ViewerPipe.Event key) {
//        }
//
//        public void mouseEntered(String id) {
//        }
//
//        public void mouseExited(String id) {
//        }
//
//        public void mouseMoved(String id, double x, double y) {
//        }
//
//        public void mouseClicked(String id) {
//        }
//
//        public void mousePressed(String id) {
//            viewer.getDefaultView().setMouseManager(new NodeMouseManager());
//        }
//
//        public void mouseReleased(String id) {
//        }
//
//        public void mouseDragged(String id, double x, double y) {
//        }
//
//        public void mouseWheelMoved(org.graphstream.ui.view.ViewerListener.MouseWheelEvent event) {
//        }
//
//		@Override
//		public void mouseLeft(String arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseOver(String arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//    }
//
//    private static class NodeMouseManager implements org.graphstream.ui.swingViewer.DefaultMouseManager {
//        @Override
//        public void mouseReleased(org.graphstream.ui.graphicGraph.GraphicElement element, org.graphstream.ui.view.View view, java.awt.event.MouseEvent event) {
//            super.mouseReleased(element, view, event);
//            viewer.getDefaultView().setMouseManager(null);
//        }
//    }
}
