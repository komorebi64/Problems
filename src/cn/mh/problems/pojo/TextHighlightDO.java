package cn.mh.problems.pojo;

/**
 * <p>文字高亮功能操作记录的领域对象</p>
 * <p>用于记录每一次高亮选择</p>
 *
 * @author komorebi
 */
public class TextHighlightDO {

    /**
     * 操作起始位置
     */
    private final Integer begin;

    /**
     * 操作结束位置
     */
    private final Integer end;

    public TextHighlightDO(Integer begin, Integer end) {
        this.begin = begin;
        this.end = end;
    }

    public Integer getBegin() {
        return begin;
    }

    public Integer getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "TextHighlightDO{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
