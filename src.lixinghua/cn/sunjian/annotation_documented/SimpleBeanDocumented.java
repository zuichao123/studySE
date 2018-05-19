package cn.sunjian.annotation_documented;

/**
 * 深入Annotation：
 * 
 * 		@Documented注释：可以用在任何的Annotation上使用
 * 
 * @author jack
 *
 */
@MyDocumentedAnnotation(key = "123",value = "456")
public class SimpleBeanDocumented{
	/**
	 * 此方法在对象输出时调用，返回对象信息
	 */
	@MyDocumentedAnnotation(key = "123",value = "456")
	public String toString(){
		return "使用javadoc -d doc SimpleBeanDocumented.java命令生成文档注释。";
	}
	
	/*
	 * 之后通过javadoc命令，生成java.doc文档
	 */
}
