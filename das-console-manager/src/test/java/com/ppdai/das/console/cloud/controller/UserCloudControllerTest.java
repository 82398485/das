package com.ppdai.das.console.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.ppdai.das.console.api.UserConfiguration;
import com.ppdai.das.console.cloud.dao.GroupCloudDao;
import com.ppdai.das.console.cloud.dao.LoginUserCloudDao;
import com.ppdai.das.console.cloud.service.ProjectCloudService;
import com.ppdai.das.console.common.interceptor.CommStatusInterceptor;
import com.ppdai.das.console.common.interceptor.permissions.UserLoginInterceptor;
import com.ppdai.das.console.constant.Message;
import com.ppdai.das.console.dao.*;
import com.ppdai.das.console.dto.entry.das.DasGroup;
import com.ppdai.das.console.service.PermissionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(UserCloudController.class)
public class UserCloudControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UserLoginInterceptor userLoginInterceptor;

    @MockBean
    private CommStatusInterceptor commStatusInterceptor;

    @MockBean
    private LoginUserCloudDao loginUserCloudDao;

    @MockBean
    private ProjectCloudService projectCloudService;

    @MockBean
    private GroupDao groupDao;

    @MockBean
    private Message message;

    @MockBean
    private ProjectDao projectDao;

    @MockBean
    private DataBaseDao dataBaseDao;

    @MockBean
    private GroupCloudDao groupCloudDao;

    @MockBean
    private DatabaseSetDao databaseSetDao;

    @MockBean
    private UserGroupDao userGroupDao;

    @MockBean
    private PermissionService permissionService;

    @MockBean
    private UserConfiguration userConfiguration;

    @MockBean
    private LoginUserDao loginUserDao;

    private MockMvc mockMvc;
    private String requestJson;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //初始化MockMvc对象
        requestJson = JSONObject.toJSONString(DasGroup.builder().id(1L).group_name("name").build());
    }

    @Test
    public void findGroupUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/das/user/group/userList")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("groupId", "1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void findUserListByUserNos() throws Exception {
        List<String> userNos = new ArrayList<>();
        userNos.add("tom");
        userNos.add("jerry");
        String requestJson = JSONObject.toJSONString(userNos);
        mockMvc.perform(MockMvcRequestBuilders.post("/das/user/userNos/userList")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
