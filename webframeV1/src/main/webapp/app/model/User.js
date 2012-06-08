Ext.define('webframe.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'username', 'firstname','lastname'],
    proxy: {
        type: 'rest',
        url: 'user',
        reader: {
            type: 'json',
            root: 'content',
            totalProperty: 'totalElements',
            successProperty: 'success'
        },
        writer: {
            type: 'json'
        }
    }
});
