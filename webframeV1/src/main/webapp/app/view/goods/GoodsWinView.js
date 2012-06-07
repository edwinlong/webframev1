/**
这里只是一个负责显示的窗口
*/
Ext.define('webframe.view.goods.GoodsWinView', {
    extend: 'Ext.window.Window',
    alias : 'widget.goodswinview',
    title : '测试',
    autoShow: false,
    height: 200,
    width: 300,
    initComponent: function() {
        this.buttons = [
            {
                text: '点我改变标题',
                scope: this,
                action: 'ok'
            },
            {
                text: '关闭',
                scope: this,
                handler: function(){
			    	this.close();
			    }
            }
        ];
        this.callParent(arguments);
    }
});