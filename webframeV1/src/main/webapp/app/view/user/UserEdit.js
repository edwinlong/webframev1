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
                        name : 'id',
                        fieldLabel: 'id',
                        hidden: true
                    },{
                        xtype: 'textfield',
                        name : 'account',
                        fieldLabel: '登录名'
                    },
                    {
                        xtype: 'textfield',
                        name : 'realName',
                        fieldLabel: '姓名'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: '邮箱'
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