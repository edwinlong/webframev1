Ext.define('webframe.model.DataDict', {
    extend: 'Ext.data.Model',
    fields: ['id', 'field', 'fieldName','valueField','displayField','enabled','sort'],
    proxy: {
        type: 'rest',
        url: 'datadict',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalElements',
            successProperty: 'success'
        },
        writer: {
            type: 'json'
        },
        //在加载后调用
        afterRequest: function(request, success) {
            //console.log(success); // either true or false
        },
        listeners: { 
        	write: function(store, operation){
        		console.log('writer listener!');
        	},
        	//异常事件，如404
            exception: function(proxy, response, options) {
            	if(response && response.responseText){//显示错误信息
            		var res = eval('('+response.responseText+')');
            		alert(res.message);
            		//alert(response.responseText);
            	}else{
            		alert('timeout!');
            	}
            }
        }
    }
});
