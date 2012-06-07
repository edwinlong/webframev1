/*
商品控制层,
所有逻辑代码都在这里写
*/
Ext.define('webframe.controller.UserCtrl', {
    extend: 'Ext.app.Controller',
    stores: ['UserStore'],//声明该控制层要用到的store
    models: ['User'],//声明该控制层要用到的model
    views: ['user.UserListView','user.UserEdit'],//声明该控制层要用到的view
    refs: [//相当于一个映射,这样就可以在控制层方便的通过geter取得相应的对象了
        {
            ref: 'userlistview',
            selector: 'userlistview'
        },
        {
            ref: 'useredit',
            selector: 'useredit'
        }
    ],
    init: function() {
        this.control({//这里的this相当于这个控制层
        	
        	'userlistview dataview': {
                itemdblclick: this.editRecord
            },
        	
            'userlistview': {
                afterrender: function(gp){//侦听userlistview渲染
                	//处理'增加'按钮的点击事件
                	var btn_add = gp.down('button[action=add]');
                	if(btn_add && this.addHandler){
	                	btn_add.on('click',function(){
	                		this.addHandler();
	                	},this);
                	}
                	
                	//处理'del'按钮的点击事件
                	var btn_del = gp.down('button[action=del]');
                	if(btn_del && this.delHandler){
	                	btn_del.on('click',function(){
	                		this.delHandler();
	                	},this);
                	}
                	
                	//处理'update'按钮的点击事件
                	var btn_update = gp.down('button[action=update]');
                	if(btn_update && this.updateHandler){
	                	btn_update.on('click',function(){
	                		this.updateHandler();
	                	},this);
                	}
                	
                	//处理'query'按钮的点击事件
                	var btn_query = gp.down('button[action=query]');
                	if(btn_query && this.queryHandler){
	                	btn_query.on('click',function(){
	                		this.queryHandler();
	                	},this);
                	}
                	/*gp.down('button[action=testBtn2]').on('click',function(){
                		//侦听userlistview工具条上action=testBtn2的按钮单击事件
                		alert(this.getUserlistview().title)
                	},this);*/
                }
            },
            'useredit button[action=save]': {
            	//侦听useredit中action=ok的按钮单击事件
                click: this.updateRecord
            }
        });
    },
    addHandler : function(){
    	alert('add');    	
    },
    delHandler : function(){
    	alert('del');    	
    },
    updateHandler : function(){
    	alert('update');    	
    },
    queryHandler : function(){
    	alert('query');    	
    },
    editRecord: function(grid, record) {
        var edit = Ext.create('webframe.view.user.UserEdit').show();

        edit.down('form').loadRecord(record);
    },
    updateRecord: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        this.getUsersStore().sync();
    }
});

