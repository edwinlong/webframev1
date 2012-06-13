Ext.define('webframe.view.datadict.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ddedit',
    title : '数据字典-编辑数据',
    autoShow: false,
    height: 200,
    width: 300,
    layout: 'fit',
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                items: [
                    {
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'id',
                        hidden: true
                    },{
                        xtype: 'textfield',
                        name : 'field',
                        fieldLabel: 'field'
                    },
                    {
                        xtype: 'textfield',
                        name : 'fieldName',
                        fieldLabel: 'fieldName'
                    },
                    {
                        xtype: 'textfield',
                        name : 'valueField',
                        fieldLabel: 'valueField'
                    },
                    {
                        xtype: 'textfield',
                        name : 'displayField',
                        fieldLabel: 'displayField'
                    },
                    {
                        xtype: 'textfield',
                        name : 'enabled',
                        fieldLabel: 'enabled'
                    },
                    {
                        xtype: 'textfield',
                        name : 'sort',
                        fieldLabel: 'sort'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});