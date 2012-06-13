Ext.Loader.setConfig({enabled:true});//开启动态加载

Ext.application({
    name: 'webframe',//为应用程序起一个名字,相当于命名空间
    
    controllers: [//声明所用到的控制层
        'DataDictCtrl'
    ],
    launch: function() {//开始
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'ddlistview'
                }
            ]
        });
    }
});

