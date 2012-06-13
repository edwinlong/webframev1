/*
*商品store
*/
Ext.define('webframe.store.DataDicts', {
    extend: 'Ext.data.Store',
    model: 'webframe.model.DataDict',
    pageSize: 10,
    //autoSync: true,
    autoLoad: true,
    baseParams: {
        page: 0,
        size: 5
    }
});
