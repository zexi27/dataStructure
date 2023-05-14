package com.zlq.blockchaindemo;

import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.blockchaindemo
 * @ClassName: Main
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/23 15:58
 */
public class Main {

    List<Block> blockChain ;

    public static void main(String[] args) {
        String[] content1 = {"xiaoming transfer 100 bitcoins to lily"};
        Block genesisBlock = new Block(0,content1);
        System.out.println("the first block hash is:");
        System.out.println(genesisBlock.getHash());

        String[] content2 = {"use 20 bitcoins buy some clothes", "earn 500 bitcoins"};
        Block block2 = new Block(genesisBlock.getHash(), content2);
        System.out.println("the second block hash is:");
        System.out.println(block2.getHash());

        String[] content3 = {"zexi transfer 10000 bitcoins to mum"};
        Block block3  = new Block(block2.getHash(), content3);
        System.out.println("the third block hash is:");
        System.out.println(block3.getHash());


    }
}
