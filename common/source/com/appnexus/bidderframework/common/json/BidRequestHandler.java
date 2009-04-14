package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.Member;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:16:19 PM
 *
 * This is the top level class which handles serialization of JSON Objects
 */
public class BidRequestHandler extends AbstractHandler<BidRequest> {


    private BidRequestHandler() {
    }
    
    public void write(Writer writer) throws IOException {

        BidRequest br = getDataObject();

        writer.append("{").append(IOUtils.LS);
        writer.append("\"timestamp\":\"").append(IOUtils.getFormattedDate(br.getTimestamp())).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"members\": [").append(IOUtils.LS);
        MemberHandler mh = MemberHandler.get();
        List<Member> members = br.getMembers();
        for (int i = 0; i < members.size(); i++) {
            if (i > 0) {
                writer.append(',').append(IOUtils.LS);
            }
            mh.setDataObject(members.get(i));
            writer.append('{');
            mh.write(writer);
            writer.append('}');
        }
        writer.append("]");

        writer.append(",").append(IOUtils.LS);
        writer.append("\"allow_exclusive\":").append(String.valueOf(br.isAllowExclusive()));

        writer.append(",").append(IOUtils.LS);
        writer.append("\"debug_requested\":").append(String.valueOf(br.isDebugRequested()));
        if (br.getTags() != null && br.getTags().size() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"tags\": [").append(IOUtils.LS);
            TagHandler th = TagHandler.get();
            List<Tag> tags = br.getTags();
            for (int i = 0; i < tags.size(); i++) {
                if (i > 0) {
                    writer.append(',').append(IOUtils.LS);
                }
                th.setDataObject(tags.get(i));
                writer.append('{');
                th.write(writer);
                writer.append('}');
            }
            writer.append("]");
        }
        if (br.getBid() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"bid_info\": {").append(IOUtils.LS);
            BidHandler bh = BidHandler.get();
            bh.setDataObject(br.getBid());
            bh.write(writer);
            writer.append("}");
        }
        writer.append("}").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            getDataObject().setTags(new ArrayList <Tag>());
        } else if ("members".equals(arrayName)) {
            getDataObject().setMembers(new ArrayList <Member>());
        }
    }

    public void startObject(String objectName) {
        BidRequest br = getDataObject();
        if ("bid_info".equals(objectName)) {
            br.setBid(new Bid());
            transferControlToNested(this, BidHandler.get(), br.getBid());
        }
    }
    
    public void readValue(String fieldName, float value) {
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("timestamp".equals(fieldName)) {
            try {
                getDataObject().setTimestamp(IOUtils.parseDate(value));
            } catch (Exception e) {
                throw new ImpBusFormatException("The date was not formatted in the yyyy-MM-dd HH:mm:ss format");
            }
        }
    }

    public void readValue(String fieldName, int value) {
    }

    public void readValue(String fieldName, boolean value) {
        if ("allow_exclusive".equals(fieldName)) {
            getDataObject().setAllowExclusive(value);
        } else if ("debug_requested".equals(fieldName)) {
            getDataObject().setDebugRequested(value);
        }
    }

    public void startObjectInArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            Tag tag = new Tag();
            getDataObject().getTags().add(tag);
            transferControlToNested(this, TagHandler.get(), tag);
        } else if ("members".equals(arrayName)) {
            Member member = new Member();
            getDataObject().getMembers().add(member);
            transferControlToNested(this, MemberHandler.get(), member);
        }
    }

    private static ThreadLocal<BidRequestHandler> factoryCache = new ThreadLocal<BidRequestHandler>() {
        public synchronized BidRequestHandler initialValue() {
            return new BidRequestHandler();
        }

        public synchronized BidRequestHandler get() {
            return super.get();
        }

        public synchronized void set(BidRequestHandler value) {
            super.set(value);
        }
    };

    public static BidRequestHandler get() {
        return factoryCache.get();
    }
}
