Ext.define('webframe.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'account', 'password','realName','sex','email','mobile','officePhone','errorCount','lastLoginTime','lastLoginIp','remark'],
    proxy: {
        type: 'rest',
        url: 'user',
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
                // response contains responseText, which has the message
                // but in unparsed Json (see below) - so I think 
                // there should be a better way to reach it than 
                // parse it myself
                console.log(proxy, response, options);
            }
        }

       /* exception: function(proxy, response, operation){
        	console.log('proxy exception');
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }*/
    }
});
