Ext.define('webframe.view.user.UserEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',
    title : '编辑用户',
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
                        name : 'username',
                        fieldLabel: 'userName'
                    },
                    {
                        xtype: 'textfield',
                        name : 'firstname',
                        fieldLabel: 'firstname'
                    },
                    {
                        xtype: 'textfield',
                        name : 'lastname',
                        fieldLabel: 'lastname'
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