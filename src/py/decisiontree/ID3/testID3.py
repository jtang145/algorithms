# -*- coding: utf-8 -*-
"""
Created on Fri Aug  3 19:52:10 2018

@author: weixw
"""
import myTrees as mt
import treePlotter as tp
#测试
dataSet, labels = mt.createDataSet()
#copy函数：新开辟一块内存，然后将list的所有值复制到新开辟的内存中
labels1 = labels.copy()
#createTree函数中将labels1的值改变了，所以在分类测试时不能用labels1
myTree = mt.createTree(dataSet,labels1)
#保存树到本地
mt.storeTree(myTree,'myTree.txt')
#在本地磁盘获取树
myTree = mt.grabTree('myTree.txt')
print (u"决策树结构：%s"%myTree)
#绘制决策树
print(u"绘制决策树：")
tp.createPlot(myTree)
numLeafs =tp.getNumLeafs(myTree)
treeDepth =tp.getTreeDepth(myTree)
print(u"叶子节点数目：%d"% numLeafs)
print(u"树深度：%d"%treeDepth)
#测试分类 简单样本数据3列
labelResult =mt.classify(myTree,labels,[1,1])
print(u"[1,1] 测试结果为：%s"%labelResult)
labelResult =mt.classify(myTree,labels,[1,0])
print(u"[1,0] 测试结果为：%s"%labelResult)