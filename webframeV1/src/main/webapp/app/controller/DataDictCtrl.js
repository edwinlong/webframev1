/*
商品控制层,
所有逻辑代码都在这里写
*/
Ext.define('webframe.controller.DataDictCtrl', {
    extend: 'Ext.app.Controller',
    stores: ['DataDicts'],//声明该控制层要用到的store
    models: ['DataDict'],//声明该控制层要用到的model
    views: ['datadict.ListView','datadict.Edit'],//声明该控制层要用到的view
    refs: [//相当于一个映射,这样就可以在控制层方便的通过geter取得相应的对象了
        {
            ref: 'ddlistview',
            selector: 'ddlistview'
        },
        {
            ref: 'ddedit',
            selector: 'ddedit'
        }
    ],
    init: function() {
        this.control({//这里的this相当于这个控制层
        	
        	'ddlistview dataview': {
                itemdblclick: this.editRecord
            },
        	
            'ddlistview': {
                afterrender: function(gp){//侦听ddlistview渲染
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
                }
            },
            'ddedit button[action=save]': {
            	//侦听ddedit中action=ok的按钮单击事件
                click: this.updateRecord
            }
        });
    },
    addHandler : function(){
    	var emptyDD = new webframe.model.DataDict({
    		username:'lllfff'
    	});
    	this.showEditWin(emptyDD);
    },
    getListViewSelection: function(){
    	var selection = this.getDdlistview().getSelectionModel().getSelection()[0];
        return selection;
    },
    delHandler : function(){
    	var selection = this.getListViewSelection();
        if (selection) {
            this.getUserStoreStore().remove(selection);
        }	
        this.getUserStoreStore().sync();
    },
    updateHandler : function(){
    	var selection = this.getListViewSelection();
    	if (selection) {
            this.showEditWin(selection);
        }
    },
    queryHandler : function(){
    	alert('query');    	
    },
    editRecord: function(grid, record) {
        this.showEditWin(record);
    },
    showEditWin: function(record) {
        var edit = Ext.create('webframe.view.user.Edit').show();
        edit.down('form').loadRecord(record);
    },
    updateRecord: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
		if (values.id > 0){
			record.set(values);
		} else{
			record = Ext.create('webframe.model.DataDict');
			record.set(values);
			//record.setId(0);
			this.getUserStoreStore().add(record);
		}
        win.close();
        this.getUserStoreStore().sync();
    }
});

