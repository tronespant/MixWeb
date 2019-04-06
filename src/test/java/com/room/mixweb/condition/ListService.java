package com.room.mixweb.condition;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:312019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
public interface ListService {

    public  String showListCmd();

    class LinuxListService implements ListService{

        @Override
        public String showListCmd() {
            return "ls";
        }
    }
    class windowsListService implements ListService{


        public  String showListCmd() {
            return "dir";
        }
    }
}
