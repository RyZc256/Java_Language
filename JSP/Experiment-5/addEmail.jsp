<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/1
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="gb2312" %>
<%
    request.setCharacterEncoding("gb2312");
    if(session.getAttribute("username")==null || session.getAttribute("username").equals("")){
        out.print("���ȵ�¼���ȴ�5���Զ����ص�¼����");
        response.setHeader("Refresh","5;URL=login.jsp");
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>��</title>
    <script>
        function verify(){
            if(pwd1.value != pwd2.value){
                alert("�������벻һ��");
                pwd1.value = "";
                pwd2.value = "";
            }
        }
    </script>
</head>
<body>
<form name="data" method="post" action="saveEmail.jsp">
    <table border="1">
        <tr>
            <td>
                ��ѡ�������Ż����䣺
            </td>
            <td>
                <input type="text" required="required" name="email" />
                <font color="red">@</font>
                <select required="required" name="domain">
                    <option value ="yahoo.cn">yahoo.cn</option>
                    <option value ="sina.com.cn">sina.com.cn</option>
                    <option value="163.com">163.com</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                ���룺
            </td>
            <td>
                <input id="pwd1" type="password" required="required" name="password" />
            </td>
        </tr>
        <tr>
            <td>
                �ٴ��������룺
            </td>
            <td>
                <input id="pwd2" type="password" required="required" name="verify_password" onblur="verify()" />
            </td>
        </tr>
        <tr>
            <td>
                ��ʵ������
            </td>
            <td>
                <input type="text" required="required" name="name" />
            </td>
        </tr>
        <tr>
            <td>
                �������ڣ�
            </td>
            <td>
                <input type="text" required="required" name="date" />
            </td>
        </tr>
        <tr>
            <td>
                �Ա�
            </td>
            <td>
                <input required="required" type="radio" name="sex" value="��">��
                <input required="required" type="radio" name="sex" value="Ů">Ů
            </td>
        </tr>
        <tr>
            <td>
                ��־���ģ�
            </td>
            <td>
                <input type="checkbox" name="Magazine" value="����" />����
                <input type="checkbox" name="Magazine" value="�ƾ�" />�ƾ�
                <input type="checkbox" name="Magazine" value="����" />����
                <input type="checkbox" name="Magazine" value="����" />����
            </td>
        </tr>
        <tr>
            <td>
                �Ż���������
            </td>
            <td >
                <textarea name="Notice" rows="5" >�Ż��й������κΰ����ڡ����ɡ������ᡢ���ػ���κ��뱾��վ�йط���(���¼�ơ�����)�����֮��Ѷ�����ݻ���(���¼�ơ����ϡ�)�����ڴ˽��ܲ����������κΡ����ϡ�����֮����Ӧ���ге����Ż��й�����Ȩ���޴����񣬸��ƻ�����ڡ����񡹻����ϡ��κβ���֮�������ʧ��</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="agree" value="ͬ���������ύ"/>
                <input type="reset" name="clear" value="���"/>
            </td>
        </tr>
    </table>
</form>



</body>
</html>
