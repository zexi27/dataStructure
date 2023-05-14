package com.zlq.blockchaindemo;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.blockchaindemo
 * @ClassName: Block
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/23 15:48
 */
public class Block {
    private int preHash;
    private String[] content;
    private int hash;

    public Block(int preHash, String[] content) {
        this.preHash = preHash;
        this.content = content;
        Object[] arr = {Arrays.hashCode(content),preHash};
        this.hash = Arrays.hashCode(arr);
    }

    public int getPreHash() {
        return preHash;
    }

    public void setPreHash(int preHash) {
        this.preHash = preHash;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }


}
