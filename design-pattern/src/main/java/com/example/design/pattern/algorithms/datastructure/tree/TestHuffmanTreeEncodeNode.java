package com.example.design.pattern.algorithms.datastructure.tree;

import java.util.*;

public class TestHuffmanTreeEncodeNode {

    public static void main(String[] args) {
        String msg = "can you can a can as a can canner a can.";
        byte[] bytes = msg.getBytes();
        byte[] b = encodeHuffman(bytes);

        byte[] decodeB = decodeHuffman(b, huffCodes);

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(decodeB));
    }

    /**
     * 进行赫夫曼编码压缩
     *
     * @param bytes
     * @return
     */
    private static byte[] encodeHuffman(byte[] bytes) {
        List<HuffmanTreeEncodeNode> huffmanTreeEncodeNodeList = getNodes(bytes);
        // 创建一棵赫夫曼树
        HuffmanTreeEncodeNode huffmanTreeEncodeNode = createHuffmanTree(huffmanTreeEncodeNodeList);
        // 创建赫夫曼编码表
        Map<Byte, String> huffCodes = getCodes(huffmanTreeEncodeNode);
        // 压缩
        byte[] encodeHuffman = encodeHuffman(bytes, huffCodes);
        return encodeHuffman;
    }

    /**
     * 解码赫夫曼编码
     *
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] decodeHuffman(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = (i == bytes.length - 1);
            sb.append(byteToBitString(b, !flag));
        }
        // 将huffman编码表的key，value交换，因为解码需要通过
        Map<String, Byte> reverseHuffmanCode = new HashMap<>();
        huffCodes.forEach((k, v) -> reverseHuffmanCode.put(v, k));

        List<Byte> byteList = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int num = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // 截取指定的长度作为key
                String key = sb.substring(i, i + num);
                // 在huffman表中查找该key
                b = reverseHuffmanCode.get(key);
                // 如果不存在，长度加1，继续遍历
                if (b == null) {
                    num++;
                } else {
                    // 如果存在，结束遍历
                    flag = false;
                }
            }
            // 存在将值放到集合中
            byteList.add(b);
            // 下次循环的开始
            i += num;
        }
        // 将集合中的值放到byte数组中
        byte[] bytes1 = new byte[byteList.size()];
        for (int i = 0; i < bytes1.length; i++) {
            bytes1[i] = byteList.get(i);
        }

        return bytes1;
    }

    /**
     * 将byte转化为二进制字符串
     *
     * @param b
     * @param flag
     * @return
     */
    private static String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= (1 << 8);
        }

        String bitString = Integer.toBinaryString(temp);
        // 最后一个byte不需要截取
        if (flag) {
            System.out.println(bitString);
            bitString = bitString.substring(bitString.length() - 8);
        }

        return bitString;
    }

    /**
     * 创建赫夫曼树
     *
     * @param huffmanTreeEncodeNodeList
     * @return
     */
    private static HuffmanTreeEncodeNode createHuffmanTree(List<HuffmanTreeEncodeNode> huffmanTreeEncodeNodeList) {
        while (huffmanTreeEncodeNodeList.size() > 1) {
            // 排序
            Collections.sort(huffmanTreeEncodeNodeList);
            // 得到最小的两个元素
            HuffmanTreeEncodeNode left = huffmanTreeEncodeNodeList.get(0);
            HuffmanTreeEncodeNode right = huffmanTreeEncodeNodeList.get(1);
            // 将最小的两个元素组装成一棵二叉树
            HuffmanTreeEncodeNode parent = new HuffmanTreeEncodeNode(null, left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            // 删除最小的两个元素
            huffmanTreeEncodeNodeList.remove(left);
            huffmanTreeEncodeNodeList.remove(right);
            // 将新树添加到集合中
            huffmanTreeEncodeNodeList.add(parent);
        }

        // 返回树的根节点
        return huffmanTreeEncodeNodeList.get(0);
    }

    private static byte[] encodeHuffman(byte[] bytes, Map<Byte, String> huffCodes) {
        // 将文本拼接为一个字符串
        StringBuilder byteContent = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byteContent.append(huffCodes.get(bytes[i]));
        }

        // 每8位截一段
        int length;
        // 为何是“8”：byte是8bit
        if (byteContent.length() % 8 == 0) {
            length = byteContent.length() / 8;
        } else {
            // 不够8位的算一个长度
            length = byteContent.length() / 8 + 1;
        }
        byte[] encodeHuffman = new byte[length];
        int index = 0;
        for (int i = 0; i < byteContent.length(); i += 8) {
            String strByte;
            if (i + 8 > byteContent.length()) {
                strByte = byteContent.substring(i);
            } else {
                strByte = byteContent.substring(i, i + 8);
            }

            // 将strByte转化为二进制
            encodeHuffman[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return encodeHuffman;
    }

    private static Map<Byte, String> getCodes(HuffmanTreeEncodeNode huffmanTreeEncodeNode) {
        if (huffmanTreeEncodeNode == null) {
            return null;
        }
        StringBuilder pathway = new StringBuilder();
        // 左子树
        getCodes(huffmanTreeEncodeNode, "0", pathway);
        // 右子树
        getCodes(huffmanTreeEncodeNode, "1", pathway);

        return huffCodes;
    }

    static Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 创建赫夫曼编码表
     *
     * @param huffmanTreeEncodeNode
     * @param code
     * @param sb
     */
    private static void getCodes(HuffmanTreeEncodeNode huffmanTreeEncodeNode, String code, StringBuilder sb) {
        StringBuilder pathway = new StringBuilder(sb);
        pathway.append(code);

        // 非叶子节点，即由最小的两个元素组成的新节点
        if (huffmanTreeEncodeNode.getData() == null) {
            getCodes(huffmanTreeEncodeNode.getLeft(), "0", pathway);
            getCodes(huffmanTreeEncodeNode.getRight(), "1", pathway);
        } else {
            // 叶子节点
            huffCodes.put(huffmanTreeEncodeNode.getData(), pathway.toString());
        }
    }


    /**
     * 将byte数组转化为HuffmanTreeEncodeNode集合
     *
     * @param bytes
     * @return
     */
    private static List<HuffmanTreeEncodeNode> getNodes(byte[] bytes) {
        List<HuffmanTreeEncodeNode> huffmanTreeEncodeNodeList = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            // 找不到，说明是一个新的元素
            if (count == null) {
                counts.put(b, 1);
            } else {
                // 找到，数量加一
                counts.put(b, count + 1);
            }
        }
        //
        counts.forEach((data, weight) -> huffmanTreeEncodeNodeList.add(new HuffmanTreeEncodeNode(data, weight)));

        return huffmanTreeEncodeNodeList;
    }
}
