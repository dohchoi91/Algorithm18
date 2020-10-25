package hackerrank.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Trees: Is This a Binary Search Tree?
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees&isFullScreen=true
 * [포인트]
 * 1. 중위 순회 
 */
public class BinarySearchTreeCheck {
	class Node {
		Node left;
		Node right;
		int data;
	}
	
	void inOrderTraverse(Node node, List<Integer> list) {
		if (node != null) {
			inOrderTraverse(node.left, list);
			list.add(node.data);
			inOrderTraverse(node.right, list);	
		}
	}

	boolean checkBST(Node root) {
		boolean result = true;
		List<Integer> list = new ArrayList<>();
		inOrderTraverse(root, list);

		int prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= prev) {
				result = false;
				break;
			}
			prev = list.get(i);
		}
		return result;
	}
}
