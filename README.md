# JFinal
JFinal 是基于Java 语言的极速 web 开发框架，其核心设计目标是开发迅速、代码量少、学习简单、功能强大、轻量级、易扩展、Restful。在拥有Java语言所有优势的同时再拥有ruby、python等动态语言的开发效率。

JFinal官方的教程都是使用Eclipse进行开发的，而使用Intellij IDEA来做开发，不少地方和Eclipse区别还是很大的。

本文参考了网上不少文章，主要沿用了网友的内容，一步一步做了尝试后记录下来，感谢万能的互联网。

分别做了两个Module，分别使用Jetty和tomcat来运行。均测试均可正常跑起来。

本文看起来虽然很长，但实际上步骤不多，为便于初学者了解Intellij IDEA,所以细节写的非常完善，每一步都有截图。

本文使用的开发环境是Intellij IDEA 14.1.4版本。JFinal是2.0版。

请大家注意：不是Intellij IDEA配置繁琐，而是我为了便于入门初学者少走弯路，写得非常细，凡是每一个出现的界面，我都截了图，而且文章里面包含了jetty和tomcat的两个项目。所以看起来比Eclipse好像复杂，其实不是的。简单地说，就五个步骤：建项目(类比于Eclipse的Workspace)，建模块(类比于Eclipse的Project)，引入Jar包，建Artifacts，写代码。就可以运行了。

### 一、新建项目

新建一个项目，可以是空项目，也可以是连模块一起建的项目，本文为了演示Jetty和tomcat均能运行的效果，所以先建一个空项目，再分别建两个不同的module，以便区分。

[![wpsF73C.tmp](http://static.oschina.net/uploads/img/201506/28235100_vmPq.jpg)](http://static.oschina.net/uploads/img/201506/28235100_3rgx.jpg)

如果项目和模块一起建，可以把Web Application选上，其他的默认就行。

[![wpsF76C.tmp](http://static.oschina.net/uploads/img/201506/28235101_qRog.jpg)](http://static.oschina.net/uploads/img/201506/28235101_AGio.jpg)

因为我们要分别测试jetty和tomcat的效果，要建两个模块，所以先建一个空项目。

[![wpsF77D.tmp](http://static.oschina.net/uploads/img/201506/28235103_e5lc.jpg)](http://static.oschina.net/uploads/img/201506/28235102_J9q3.jpg)

点击“Next”进入下一步。

[![wpsF79D.tmp](http://static.oschina.net/uploads/img/201506/28235104_gse8.jpg)](http://static.oschina.net/uploads/img/201506/28235104_F0nO.jpg)

输入项目名称和项目所在目录，点击“Finish”即可。

### 二、项目参数配置

#### 1．新建Module

如果新建一个空项目，会立即出来一个Project Structure的配置窗口。如果是连模块一起建的，请从【File】-【Project Structure】中选择，对项目参数进行配置。

首先指定项目所使用的JDK版本：

![img](http://static.oschina.net/uploads/space/2015/0629/172633_oAbn_97615.png)

如果要单独为每个模块指定JDK版本，也可以在模块中进行配置(要在下面的新建模块步骤之后才能操作)。

![img](http://static.oschina.net/uploads/space/2015/0629/172735_2yEM_97615.png)

下面开始新建模块。

[![wpsF7BD.tmp](http://static.oschina.net/uploads/img/201506/28235105_a3bo.jpg)](http://static.oschina.net/uploads/img/201506/28235105_RFMm.jpg)

选择Modules，准备新建Module。

[![wpsF7CE.tmp](http://static.oschina.net/uploads/img/201506/28235106_b2IM.jpg)](http://static.oschina.net/uploads/img/201506/28235105_iZhm.jpg)

#### 2．建Jetty运行模块

##### （1）新建模块

我们先新建一个module，用于使用jetty来运行。

[![wpsF7DE.tmp](http://static.oschina.net/uploads/img/201506/28235112_e6j6.jpg)](http://static.oschina.net/uploads/img/201506/28235112_EKdy.jpg)

选上“Web Application”后，点击Next。

在出现的窗口中，直接在Module name中输入想要新建的module名字，下面的Content root和Module file location中会自动把路径填进去。

为了便于区分，我们把jetty运行的module命名为jf_jt。

点击“Finish”。

[![wpsF81E.tmp](http://static.oschina.net/uploads/img/201506/28235113_BnoA.jpg)](http://static.oschina.net/uploads/img/201506/28235113_xIxo.jpg)

此时会出现如下界面；

选择“Paths”选项卡，选中“Use module compile output path”后，在“Output path”和“Test output path”中均写上类输出的路径。按照一般常规写法，我把这个目录放在module下，web\WEB-INF路径下的classes目录下。

[![wpsF83E.tmp](http://static.oschina.net/uploads/img/201506/28235115_2IQs.jpg)](http://static.oschina.net/uploads/img/201506/28235114_t5IN.jpg)

点击“Apply”，把配置启用起来；

##### （2）导入类库

然后点击左侧的Libraries选项卡；

[![wpsF8AC.tmp](http://static.oschina.net/uploads/img/201506/28235116_R8z6.jpg)](http://static.oschina.net/uploads/img/201506/28235115_bT0F.jpg)

在做这一步之前，我们先要把需要的类库分别拷贝到我们建立的类库目录中。

这个模块是需要jetty来运行的，所以需要JFinal的类库和jetty的类库，事先准备好这几个类库。

Jfinal-2.0-all目录下有需要的类库文件。

[![wpsF8DC.tmp](http://static.oschina.net/uploads/img/201506/28235118_5V4U.jpg)](http://static.oschina.net/uploads/img/201506/28235117_pBti.jpg)

“jfinal-2.0-bin.jar”或“jfinal-2.0-bin-with-src.jar”是jfinal本身的jar包，任选一个都可以，为了方便调试，可以选择“jfinal-2.0-bin-with-src.jar”。

目前这个项目是为了Jetty而建的，所以要把“jetty-server-8.1.8.jar”也要包含进去。

&#160;&#160;&#160;&#160; 在电脑中找到项目目录，进入到Module路径中，新建文件夹；

[![wpsF90C.tmp](http://static.oschina.net/uploads/img/201506/28235119_xstj.jpg)](http://static.oschina.net/uploads/img/201506/28235118_JsSv.jpg)

新建一个classes目录(上文新建module时设置的输出目录)和lib目录；

[![wpsF91C.tmp](http://static.oschina.net/uploads/img/201506/28235120_IPtf.jpg)](http://static.oschina.net/uploads/img/201506/28235119_NoRO.jpg)

把“jfinal-2.0-bin.jar”和“jetty-server-8.1.8.jar”两个文件拷贝到刚才新建的lib目录下(注意，使用jfinal-2.0-bin.jar和使用jfinal-2.0-bin-src.jar，后续界面会略有不同，但差异不大)。

[![wpsF92D.tmp](http://static.oschina.net/uploads/img/201506/28235121_30Sq.jpg)](http://static.oschina.net/uploads/img/201506/28235120_kR5d.jpg)

回到Intellij IDEA配置界面。

选择左侧的Libraries选项卡，点击中间的“+”号，新增java类库。

[![wpsF93D.tmp](http://static.oschina.net/uploads/img/201506/28235122_y5nP.jpg)](http://static.oschina.net/uploads/img/201506/28235122_R5Ui.jpg)

在弹出的窗口中，找到lib目录并选中刚才拷进去的“jfinal-2.0-bin-with-src.jar”包。

[![wpsF94E.tmp](http://static.oschina.net/uploads/img/201506/28235123_xs9E.jpg)](http://static.oschina.net/uploads/img/201506/28235123_hOop.jpg)

点击“OK”。

此时会让你选择这些类库将用于哪些module（如果你在项目中有多个module,在此均会列出来）在这里，我们选择这些类库用于“jf_jt”module。

此时类库就会出现在列表里。

[![wpsF96E.tmp](http://static.oschina.net/uploads/img/201506/28235124_1DKd.jpg)](http://static.oschina.net/uploads/img/201506/28235124_FNZh.jpg)

点击“Apply”，保存配置。

再重复上述步骤，导入jetty的jar包。导入后如下图所示：

[![wpsF97F.tmp](http://static.oschina.net/uploads/img/201506/28235129_JcU9.jpg)](http://static.oschina.net/uploads/img/201506/28235125_OTWk.jpg)

再选择左侧的“Artifacts”选项卡，此时会出现空白的Artifacts界面。

[![wpsF99F.tmp](http://static.oschina.net/uploads/img/201506/28235130_abDo.jpg)](http://static.oschina.net/uploads/img/201506/28235129_D3Cl.jpg)

或出现已经有一个“jf_ft.war exploded”的界面(如果关闭后重新打开Project Structure界面就会出现)。建议：最好在导入类库后，点击“OK”，关闭本界面后，重新通过【File】-【Project Structure】菜单打开本界面后，选“Artifacts”选项卡进行操作，避免重复建立jf-ft.war exploded。

重新打开界面，并选择Artifacts选项卡后，界面会如下图所示：

[![wpsF9B0.tmp](http://static.oschina.net/uploads/img/201506/28235131_Kurz.jpg)](http://static.oschina.net/uploads/img/201506/28235130_W5Kg.jpg)

此时窗口下部会出现一条告警信息。如上图红框部分。

此时点击“Fix…”按键，选择“Add‘jfinal-2.0-bin-with-src’to the artifact”，即可。

[![wpsF9C0.tmp](http://static.oschina.net/uploads/img/201506/28235132_gTrC.jpg)](http://static.oschina.net/uploads/img/201506/28235131_Mrpk.jpg)

设置好的界面如下图所示（把Build on make选上）；

点击“Apply”按钮保存设置；

[![wpsF9D1.tmp](http://static.oschina.net/uploads/img/201506/28235134_B9E0.jpg)](http://static.oschina.net/uploads/img/201506/28235133_FuED.jpg)

再点击“+”号，添加一个“Web Application：Archive”，此时选“For ‘jfjt:war exploded’”；

[![wpsF9E1.tmp](http://static.oschina.net/uploads/img/201506/28235137_P1R8.jpg)](http://static.oschina.net/uploads/img/201506/28235135_HOJU.jpg)

建好后，界面如下图所示(如果还有告警提示，按照上面步骤，点击“Fix”按键把类库添加进Artifact中);

选中“Build on make”选项后，点“OK”按键保存并退出配置界面。

[![wpsF9F2.tmp](http://static.oschina.net/uploads/img/201506/28235138_t3qC.jpg)](http://static.oschina.net/uploads/img/201506/28235137_OUYS.jpg)

至此Jetty运行的模块已经建好。

#### 3．建Tomcat运行模块

##### （1）新建模块

点击【File】-【New】-【Module】：

[![wpsFA03.tmp](http://static.oschina.net/uploads/img/201506/28235140_t1Gq.jpg)](http://static.oschina.net/uploads/img/201506/28235138_fv6e.jpg)

选上“Web Application”，并点“Next”：

[![wpsFA23.tmp](http://static.oschina.net/uploads/img/201506/28235140_LWEi.jpg)](http://static.oschina.net/uploads/img/201506/28235140_v1GG.jpg)

填上Module的名称，这里起名为jf-tc,然后点击“Finish”：

[![wpsFA33.tmp](http://static.oschina.net/uploads/img/201506/28235141_w2kt.jpg)](http://static.oschina.net/uploads/img/201506/28235141_FJZ4.jpg)

此时的界面是这样：

[![wpsFA44.tmp](http://static.oschina.net/uploads/img/201506/28235143_rHfe.jpg)](http://static.oschina.net/uploads/img/201506/28235142_6AKc.jpg)

##### （2）导入类库

现在可以直接在IDEA的界面建目录classes和lib。

鼠标右键点击[jf-tc]-[web]-[WEB-INF]目录，在出来的菜单里点击【New】-【Directory】。

[![wpsFA55.tmp](http://static.oschina.net/uploads/img/201506/28235144_dkn6.jpg)](http://static.oschina.net/uploads/img/201506/28235143_oBn2.jpg)

输入classes和lib目录的名称：

[![wpsFA65.tmp](http://static.oschina.net/uploads/img/201506/28235145_LPPm.jpg)](http://static.oschina.net/uploads/img/201506/28235145_9Tfb.jpg)

建好目录后的模块如下所示:

[![wpsFA66.tmp](http://static.oschina.net/uploads/img/201506/28235146_2RMM.jpg)](http://static.oschina.net/uploads/img/201506/28235146_mAu7.jpg)

点击【File】-【Project Structure】进入项目，步骤和上一个模块建立的时候一样，此时界面里已经有两个模块，选中jf-tc模块后，设置Path：

[![wpsFA77.tmp](http://static.oschina.net/uploads/img/201506/28235149_E7Yw.jpg)](http://static.oschina.net/uploads/img/201506/28235147_FfdC.jpg)

接下来再设置Libraries，在此之前，需要把jfinal-2.0-bin-with-src.jar拷贝到lib目录下。

[![wpsFA78.tmp](http://static.oschina.net/uploads/img/201506/28235149_mkhy.jpg)](http://static.oschina.net/uploads/img/201506/28235149_1KyL.jpg)

在“Libraries”选项卡中点“+”号，选“Java”：

[![wpsFA88.tmp](http://static.oschina.net/uploads/img/201506/28235150_59Cs.jpg)](http://static.oschina.net/uploads/img/201506/28235150_S0A2.jpg)

这里只需要导入一个jar包即可(记住，目录不要选错，要选刚才拷进去的jf-tc模块下lib目录的jfinal-2.0-bin-with-src.jar文件)。

[![wpsFA99.tmp](http://static.oschina.net/uploads/img/201506/28235152_cr0g.jpg)](http://static.oschina.net/uploads/img/201506/28235151_0l2y.jpg)

注意：选中目标Jar包后，选模块的时候，一定不要选错。

[![wpsFAAA.tmp](http://static.oschina.net/uploads/img/201506/28235153_8NX2.jpg)](http://static.oschina.net/uploads/img/201506/28235152_t7dB.jpg)

点“OK”后，来到Artifacts选项卡：

[![wpsFACA.tmp](http://static.oschina.net/uploads/img/201506/28235154_V1jE.jpg)](http://static.oschina.net/uploads/img/201506/28235153_9q1k.jpg)

添加一个Artifact

[![wpsFADA.tmp](http://static.oschina.net/uploads/img/201506/28235156_EMUt.jpg)](http://static.oschina.net/uploads/img/201506/28235154_00ac.jpg)

记住不要选错模块。

添加成功后，记住Fix掉警告信息(新加的两个Artifact都要fix)。然后都选上“Build on make”选项。

[![wpsFAFB.tmp](http://static.oschina.net/uploads/img/201506/28235157_gwKG.jpg)](http://static.oschina.net/uploads/img/201506/28235157_Hl0x.jpg)

至此，两个模块都建好，可以开始真正的编写代码之旅了。

### 三、修改运行配置

#### 1．创建Jetty运行配置

点击【run】-【Edit Configurations】菜单：

[![wpsFB1B.tmp](http://static.oschina.net/uploads/img/201506/28235159_z2Cy.jpg)](http://static.oschina.net/uploads/img/201506/28235159_a43o.jpg)

出现下面的界面，并点击左上角的“+”号，选“Application”选项：

[![wpsFB3B.tmp](http://static.oschina.net/uploads/img/201506/28235200_j135.jpg)](http://static.oschina.net/uploads/img/201506/28235200_fMYt.jpg)

设置一个名称，在这里命名为“jf-jt-jetty”。

设置Main Class(在出来的“Choose Main Class”窗口里直接输入com.jfinal……,下面会直接把class列出来，不用搜索和查找).

[![wpsFB7A.tmp](http://static.oschina.net/uploads/img/201506/28235202_iNAk.jpg)](http://static.oschina.net/uploads/img/201506/28235201_jtLy.jpg)

设好Main Class以后，设置“working directory”和“Use classpath of module”两项，如下图所示：

[![wpsFB9B.tmp](http://static.oschina.net/uploads/img/201506/28235203_sGnV.jpg)](http://static.oschina.net/uploads/img/201506/28235202_eciC.jpg)

点击“OK”，设置完成。

#### 2．创建tomcat运行配置

点击【run】-【Edit Configurations】菜单：

[![wpsFBEA.tmp](http://static.oschina.net/uploads/img/201506/28235204_JK2B.jpg)](http://static.oschina.net/uploads/img/201506/28235203_Rbjq.jpg)

选择【Tomcat Server】-【local】菜单：

[![wpsFC0A.tmp](http://static.oschina.net/uploads/img/201506/28235207_vW1L.jpg)](http://static.oschina.net/uploads/img/201506/28235205_GVe4.jpg)

配置Tomcat参数，起一个名字，然后点击最右边的“+”号，增加一个Artifact：

[![wpsFC1A.tmp](http://static.oschina.net/uploads/img/201506/28235209_5GeV.jpg)](http://static.oschina.net/uploads/img/201506/28235208_UTEY.jpg)

在出来的窗口中，选“jf-tc:war exploded”即exploded的那个war。

[![wpsFC4A.tmp](http://static.oschina.net/uploads/img/201506/28235210_SqMy.jpg)](http://static.oschina.net/uploads/img/201506/28235209_U6Lh.jpg)

点击“OK”后，就配置完成了。

[![wpsFC5B.tmp](http://static.oschina.net/uploads/img/201506/28235211_cxG2.jpg)](http://static.oschina.net/uploads/img/201506/28235211_858b.jpg)

注意，这个Application context里填写的路径，是你调试或运行时出现的url的后缀，比如，如果你在此设置“/”，则最后是通过“http://localhost:8080/”运行和调试；假如你在此设置为“/test”，则最后是通过“http://localhost:8080/test”进行访问和调试。

### 四、添加源文件

现在可以添加源文件了。我们可以分别在两个项目下建立源文件(建源文件的过程不管上面jetty和tomcat项目都是一样的，我们以tomcat项目来举例):

我们在src路径下，添加一个package名称为com.demo.

[![wpsFD75.tmp](http://static.oschina.net/uploads/img/201506/28235212_urOA.jpg)](http://static.oschina.net/uploads/img/201506/28235212_txUY.jpg)

[![wpsFD85.tmp](http://static.oschina.net/uploads/img/201506/28235213_Y4KJ.jpg)](http://static.oschina.net/uploads/img/201506/28235213_ktMB.jpg)

再在这个package下建三个类：

[![wpsFDA5.tmp](http://static.oschina.net/uploads/img/201506/28235215_NbfG.jpg)](http://static.oschina.net/uploads/img/201506/28235215_qfXT.jpg)

[![wpsFDA6.tmp](http://static.oschina.net/uploads/img/201506/28235216_ttSR.jpg)](http://static.oschina.net/uploads/img/201506/28235215_Fi2A.jpg)

内容如下：

[![wpsFDC7.tmp](http://static.oschina.net/uploads/img/201506/28235216_glPq.jpg)](http://static.oschina.net/uploads/img/201506/28235216_YekL.jpg)

另外再建两个类HelloController.java和Indexcontroller.java,内容分别如下：

[![wpsFDC8.tmp](http://static.oschina.net/uploads/img/201506/28235217_59HP.jpg)](http://static.oschina.net/uploads/img/201506/28235217_9j4K.jpg)

[![wpsFDD8.tmp](http://static.oschina.net/uploads/img/201506/28235219_8KGV.jpg)](http://static.oschina.net/uploads/img/201506/28235218_Qr49.jpg)

编辑模块下，web\WEB-INF路径下的web.xml文件，内容如下：

[![wpsFDE9.tmp](http://static.oschina.net/uploads/img/201506/28235224_T3EH.jpg)](http://static.oschina.net/uploads/img/201506/28235220_nLEe.jpg)

至此，tomcat部分已经完成，按同样的方式配置jetty部分(也可以直接把package和web.xml文件直接拷贝过去)。

### 五、运行项目

#### 1．在jetty下运行

点击【Run】-【Run】菜单：

[![wpsFDF9.tmp](http://static.oschina.net/uploads/img/201506/28235225_HtJj.jpg)](http://static.oschina.net/uploads/img/201506/28235225_ga12.jpg)

页面中间会出现让你选择运行哪个模块的选项，我们选择jetty的模块。

[![wpsFDFA.tmp](http://static.oschina.net/uploads/img/201506/28235228_hEZm.jpg)](http://static.oschina.net/uploads/img/201506/28235225_4NjU.jpg)

此时IDEA界面下半部会显示jetty的启动信息，如下：

[![wpsFE0B.tmp](http://static.oschina.net/uploads/img/201506/28235235_TVgo.jpg)](http://static.oschina.net/uploads/img/201506/28235232_XrXp.jpg)

说明jetty已经正常启动了。

此时需要手动打开浏览器页面，输入“http://localhost”，就会出现Index控制器对应的页面。(注意，如果你的电脑上装了别的Web服务器，注意端口冲突)。

[![wpsFE1C.tmp](http://static.oschina.net/uploads/img/201506/28235238_Pifw.jpg)](http://static.oschina.net/uploads/img/201506/28235237_kWkJ.jpg)

IDEA下部窗口会出现相应的调试信息。

[![wpsFE2C.tmp](http://static.oschina.net/uploads/img/201506/28235242_B67s.jpg)](http://static.oschina.net/uploads/img/201506/28235240_lNEf.jpg)

输入http://localhost/hello,会出现hello控制器对应的页面。

[![wpsFE3D.tmp](http://static.oschina.net/uploads/img/201506/28235249_iQco.jpg)](http://static.oschina.net/uploads/img/201506/28235248_mTDM.jpg)

#### 2．在tomcat下运行

同样点击【Run】-【Run】菜单，在页面中心的弹出菜单选“jf-tc-tomcat”。

IDEA界面下半部分会显示启动tomcat过程中的日志，等待tomcat启动后，会自动调用本地浏览器窗口，把index页面内容显示出来。

[![wpsFE4D.tmp](http://static.oschina.net/uploads/img/201506/28235251_jFXi.jpg)](http://static.oschina.net/uploads/img/201506/28235250_6eyX.jpg)

输入http://loaclhost:8080/hello

出来hello控制器中的内容：

[![wpsFE4E.tmp](http://static.oschina.net/uploads/img/201506/28235253_3vY9.jpg)](http://static.oschina.net/uploads/img/201506/28235252_oz5S.jpg)

### 六、项目实际部署

Intellij IDEA打包的war文件位于项目根目录的out目录下。

[![wpsFE5F.tmp](http://static.oschina.net/uploads/img/201506/28235254_XcZJ.jpg)](http://static.oschina.net/uploads/img/201506/28235254_Zs7M.jpg)

把此文件拷贝到tomcat的webapps目录下(可以改名，例如改名为test.war),无需做任何修改，启动tomcat后，直接访问：[http://ip:8080/test/](http://ip:8080/test/)即可正常访问页面。

要更改输出目录，请在【File】-【Project Structure】-【Project】标签页修改即可。
