/*!
* 商品view层,这里只是一个负责显示的grid,没有逻辑代码
*/
Ext.define('webframe.view.goods.GoodsListView' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.goodslistview',
    title : '用户列表',
    store: 'UserStore',
    columns: [
        {header: '用户编码',  dataIndex: 'id'},
        {header: '用户名', dataIndex: 'username'},
        {header: '姓', dataIndex: 'firstname'},
        {header: '名', dataIndex: 'lastname'}
    ],
    tbar : [
    	{text:'测试1',action:'testBtn1'},
    	{text:'测试2',action:'testBtn2'}
    ]
});

