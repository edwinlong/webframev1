Ext.define('webframe.view.datadict.ListView' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.ddlistview',
    title : '系统数据字典',
    //model: 'User',
    store: 'DataDicts',
    columns: [
        {header: '编号',  dataIndex: 'id'},
        {header: 'field', dataIndex: 'field'},
        {header: 'fieldName', dataIndex: 'fieldName'},
        {header: 'valueField', dataIndex: 'valueField'},
        {header: 'displayField', dataIndex: 'displayField'},
        {header: 'enabled', dataIndex: 'enabled'},
        {header: 'sort', dataIndex: 'sort'}
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

