Ext.define('webframe.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'username', 'firstname','lastname'],
    proxy: {
        type: 'ajax',
        api: {
            read: 'app/users.json' //只是一个数据接口,可以按需改变
        },
        reader: {
            type: 'json',
            root: 'results',
            successProperty: 'success'
        }
    }
    /*proxy: {
        type: 'rest',
        url: '/user',
        reader: {
            type: 'json',
            root: 'results',
            successProperty: 'success'
        },
        writer: {
            type: 'json'
        }
    }*/
});
