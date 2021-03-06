package com.room.mixweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.room.mixweb.domain.PageFormData;
import com.room.mixweb.utils.TranformToJson;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 21:17 2019/3/13
 * @Modify by:
 */
@RestController
@RequestMapping(value = "/activiti")
public class ActivitiController {

    @Autowired
    RepositoryService repositoryService;
    /**
     * 创建模型
     */
    @RequestMapping("/create")
    public void create(HttpServletRequest request, HttpServletResponse response) {
        try {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

            RepositoryService repositoryService = processEngine.getRepositoryService();

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, "hello1111");
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            String description = "hello1111";
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName("hello1111");
            modelData.setKey("12313123");

            //保存模型
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
            response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
        } catch (Exception e) {
            System.out.println("创建模型失败：");
        }
    }
    @RequestMapping(value = "/getModel")
    public String getModel(){
        PageFormData<Model> pfd= new PageFormData();
        List<Model> list = repositoryService.createModelQuery().orderByModelId().asc().list();
        pfd.setCode(0);
        pfd.setCount(list.size());
        pfd.setMsg("测试");

        TranformToJson<PageFormData> tr= new TranformToJson<>();
        TranformToJson<Model> tr1=new TranformToJson<>();
        String[] ex={"category","editorSourceExtraValueId","metaInfo","createTime"};
        pfd.setData(list);
        String modelJson = tr.toJsonByObject(pfd,ex);

        return modelJson;
    }

}
