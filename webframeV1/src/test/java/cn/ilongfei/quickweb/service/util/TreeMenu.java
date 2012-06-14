package cn.ilongfei.quickweb.service.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.ilongfei.quickweb.model.Module;
import cn.ilongfei.quickweb.model.Role;
import cn.ilongfei.quickweb.model.Tree;
import cn.ilongfei.quickweb.model.User;

/**
 * 菜单类1.1
 * 
 * 
 */
public class TreeMenu {

	private List<Module> list;
	private Module root;

	public TreeMenu(User user) {
		this.list = new ArrayList<Module>();
		this.root = new Module();
		Set<Module> _tmp = new HashSet<Module>();
		Iterator<Role> roles = user.getRoles().iterator();
		while(roles.hasNext()){
			Role role = roles.next();
			_tmp.addAll(role.getModules());
		}
		list.addAll(_tmp);
	}

	/**
	 * 组合json
	 * 
	 * @param list
	 * @param node
	 */
	private Tree getNodeJson(List<Module> list, Module node) {
		Tree tree = new Tree();
		tree.setId(node.getId()==null?0:node.getId());
		tree.setText(node.getModuleName());
		tree.setIconCls(node.getIconCss());
		tree.setChildren(new ArrayList<Tree>());
		if (list == null) {
			// 防止没有权限菜单时
			return tree;
		}
		if (hasChild(list, tree.getId())) {
			List<Tree> lt = new ArrayList<Tree>();
			tree.setUrl("");
			tree.setLeaf(node.getLeaf() == 1 ? true : false);
			tree.setExpanded(node.getExpanded() == 1 ? true : false);
			List<Module> childList = getChildList(list, tree.getId());
			Iterator<Module> it = childList.iterator();
			while (it.hasNext()) {
				Module modules = (Module) it.next();
				// 递归
				lt.add(getNodeJson(list, modules));
			}
			tree.setChildren(lt);
			// } else if ((node.getParentId() == root.getModuleId()) ||
			// node.getModuleUrl() == null) {
			// // 防止是主菜单,或者主菜单里面的url为空，但是下面没有子菜单的时候
			// tree.setUrl("");
			// tree.setLeaf(node.getLeaf() == 1 ? true : false);
			// tree.setExpanded(node.getExpanded() == 1 ? true : false);
		} else {
			tree.setUrl(node.getModuleUrl());
			tree.setLeaf(node.getLeaf() == 1 ? true : false);
			tree.setExpanded(node.getExpanded() == 1 ? true : false);
		}

		return tree;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<Module> list, long id) {
		return getChildList(list, id).size() > 0 ? true : false;
	}

	/**
	 * 得到子节点列表
	 */
	private List<Module> getChildList(List<Module> list, long id) {
		List<Module> li = new ArrayList<Module>();
		Iterator<Module> it = list.iterator();
		while (it.hasNext()) {
			Module temp = (Module) it.next();
			if (temp.getParentId() == id) {
				li.add(temp);
			}
		}
		return li;
	}

	public Tree getTreeJson() {
		// 父菜单的id为0
		//this.root.setId(0L);
		this.root.setLeaf((short) 0);
		this.root.setExpanded((short) 0);
		return this.getNodeJson(this.list, this.root);
	}
}
