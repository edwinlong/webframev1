Ext.define('webframe.view.user.UserListView' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlistview',
    title : '用户列表',
    //model: 'User',
    store: 'UserStore',
    columns: [
        {header: '用户编码',  dataIndex: 'id'},
        {header: '用户名', dataIndex: 'username'},
        {header: '姓', dataIndex: 'firstname'},
        {header: '名', dataIndex: 'lastname'}
    ],
    tbar : [
    	{text:'增加',action:'add',tooltip:'增加记录',icon: 'resources/icons/fam/add.gif', cls: 'x-btn-text-icon'},
    	'-',
    	{text:'修改',action:'update',tooltip:'修改选中记录',icon: 'resources/icons/fam/folder_wrench.png', cls: 'x-btn-text-icon'},
    	'-',
    	{text:'删除',action:'del',tooltip:'删除选中记录',icon: 'resources/icons/fam/delete.gif', cls: 'x-btn-text-icon'},
    	'-',
    	{text:'查询',action:'query',tooltip:'条件查询',icon: 'resources/icons/fam/application_view_list.png', cls: 'x-btn-text-icon'}
    ]
});

