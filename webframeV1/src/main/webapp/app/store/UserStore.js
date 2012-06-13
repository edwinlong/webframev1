/*
*商品store
*/
Ext.define('webframe.store.UserStore', {
    extend: 'Ext.data.Store',
    model: 'webframe.model.User',
    pageSize: 10,
    //autoSync: true,
    autoLoad: true,
    baseParams: {
        page: 0,
        size: 5
    }
});
