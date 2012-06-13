insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('sex', '性别', '0', '男', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('sex', '性别', '0', '男', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('sex', '性别', '1', '女', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('sex', '性别', '2', '其他', 1, 3);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('sex', '性别', '3', '保密', 0, 4);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '10', '10条/页', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '20', '20条/页', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '30', '30条/页', 1, 3);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '50', '50条/页', 1, 4);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('theme', '风格', 'xtheme-blue.css', '经典蓝色', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('theme', '风格', 'xtheme-gray.css', '简约灰色', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('leaf', '父模块', '0', '父节点', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('leaf', '父模块', '1', '子节点', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('expanded', '展开状态', '0', '收缩', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('expanded', '展开状态', '1', '展开', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('isdisplay', '是否显示', '0', '否', 1, 1);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('isdisplay', '是否显示', '1', '是', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '100', '100条/页', 1, 5);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '200', '200条/页', 1, 6);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('pagesize', '每页显示条数', '500', '500条/页', 0, 7);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('enabled', '是否启用', '0', '禁用', 1, 2);
insert into field (field, fieldName, valueField, displayField, enabled, sort)values ('enabled', '是否启用', '1', '启用', 1, 1);

insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (14, '系统字段管理', '/field', 1, 1, 1, 4, 1, 'field', 'field', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (11, '角色管理', '/role', 1, 1, 0, 3, 1, 'Role Management', 'role', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (12, '用户管理', '/user', 1, 1, 0, 2, 1, 'User Management', 'user', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (13, '模块管理', '/module', 1, 1, 0, 1, 1, 'Module Management', 'module', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (1, '系统设置', null, 0, 0, 1, 1, 1, 'System Settings', 'system_settings', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (2, '供应商管理', null, 0, 0, 1, 2, 1, 'Operator', 'abc', null);
insert into MODULE (id, moduleName, moduleurl, parentid, leaf, expanded, displayindex, isdisplay, enmoduleName, iconcss, information)
values (21, '供应商信息', '/oprator', 2, 1, 0, 1, 1, 'oprator', 'cde', null);

insert into ROLEMODULE (id, roleid, moduleid)values (1, 2, 2);
insert into ROLEMODULE (id, roleid, moduleid)values (2, 2, 21);
insert into ROLEMODULE (id, roleid, moduleid)values (3, 1, 1);
insert into ROLEMODULE (id, roleid, moduleid)values (4, 1, 2);
insert into ROLEMODULE (id, roleid, moduleid)values (5, 1, 13);
insert into ROLEMODULE (id, roleid, moduleid)values (6, 1, 12);
insert into ROLEMODULE (id, roleid, moduleid)values (7, 1, 11);
insert into ROLEMODULE (id, roleid, moduleid)values (8, 1, 14);
insert into ROLEMODULE (id, roleid, moduleid)values (9, 1, 21);


insert into USER (id, account, password, realname, sex, email, mobile, officephone, lastlogintime, lastloginip, remark)values (1, 'test', 'c0f40fddd2c81de6bd37023d8219782f', '测试用户', 0, 'test@qq.com', '119', '110', '2012-11-2', null, null);
insert into USER (id, account, password, realname, sex, email, mobile, officephone, lastlogintime, lastloginip, remark)values (2, 'admin', 'c0f40fddd2c81de6bd37023d8219782f', '超级管理员', 0, 'admin@whty.com.cn', '119', '110', '2012-2-20 12:01:36', '127.0.0.1', '用户信息');

insert into ROLE (id, rolename, roledesc)values (1, '管理员', '管理员');
insert into ROLE (id, rolename, roledesc)values (2, '测试角色', '测试角色');


insert into USERROLE (id, userid, roleid)values (1, 2, 1);
insert into USERROLE (id, userid, roleid)values (2, 1, 2);
