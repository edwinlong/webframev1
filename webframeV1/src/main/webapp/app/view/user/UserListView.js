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
    	{text:'增加',action:'add',tooltip:'增加记录',iconCls: 'icon-add'},
    	'-',
    	{text:'修改',action:'update',tooltip:'修改选中记录',iconCls: 'icon-update'},
    	'-',
    	{text:'删除',action:'del',tooltip:'删除选中记录',iconCls: 'icon-delete'},
    	'-',
    	{text:'查询',action:'query',tooltip:'条件查询',iconCls: 'icon-query'}
    ],
    
    
    initComponent: function() { 
        this.bbar = Ext.create('Ext.PagingToolbar', { 
            store: this.store,
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display"
        });
        this.callParent();
    }

});

