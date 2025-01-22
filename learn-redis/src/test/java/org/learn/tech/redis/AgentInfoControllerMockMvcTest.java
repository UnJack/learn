package org.learn.tech.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 代理商Mock测试类
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class AgentInfoControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

//    /**
//     * 新增代理商
//     */
//    @Test
//    public void save() {
//        try {
//            AgentDto agentDto = TestDTOFactory.buildAgentDto();
//            String requestBody = JSONObject.toJSONString(agentDto);
//            ResponseResult<String> result = ResponseResult.error("Request error! invalid argument [hostPath: "
//                    + "参数hostPath不能为空]");
//            mockMvc.perform(MockMvcRequestBuilders.post("/agent/save")
//                            .contentType(MediaType.APPLICATION_JSON).content(requestBody))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().json(JSON.toJSONString(result)));
//        } catch (Exception e) {
//            log.error("save:", e);
//        }
//    }
//
//    /**
//     * 新增代理商
//     */
//    @Test
//    public void getAgentList() {
//        try {
//            ResponseResult<Void> result = ResponseResult.success();
//            mockMvc.perform(MockMvcRequestBuilders.get("/agent/getAgentList"))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().json(JSON.toJSONString(result)));
//        } catch (Exception e) {
//            log.error("save:", e);
//        }
//    }

}
