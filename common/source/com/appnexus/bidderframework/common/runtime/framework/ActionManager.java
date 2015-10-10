/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 20, 2009
 * Time: 7:51:18 PM
 * 
 * updated by @author Helmut Steiner
 * 
 */
package com.appnexus.bidderframework.common.runtime.framework;

import org.apache.log4j.Logger;
import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IBidResponseAction;
import com.appnexus.bidderframework.common.runtime.actions.IClickRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.INotifyRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IPixelRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IPixelResponseAction;
import com.appnexus.bidderframework.common.BidderFrameworkActionException;

public class ActionManager {

    private static final ActionManager INSTANCE = new ActionManager();
    private static final Logger LOG = Logger.getLogger(ActionManager.class);

    private String bidRequestActionClassName;
    private String bidResponseActionClassName;
    private String notifyRequestActionClassName;
    private String clickRequestActionClassName;
    private String pixelRequestActionClassName;
    private String pixelResponseActionClassName;
    
    private String getTractorBidings;

    private ActionManager() {
    }

    public static ActionManager getInstance() {
        return INSTANCE;
    }

    public void registerBidRequestAction(String bidRequestActionClassName) {
        this.bidRequestActionClassName = bidRequestActionClassName;
    }

    public void registerBidResponseAction(String bidResponseActionClassName) {
        this.bidResponseActionClassName = bidResponseActionClassName;
    }

    public void registerNotifyRequestActionClassName(String notifyRequestActionClassName) {
        this.notifyRequestActionClassName = notifyRequestActionClassName;
    }

    public void registerClickRequestActionClassName(String clickRequestActionClassName) {
        this.clickRequestActionClassName = clickRequestActionClassName;
    }

    public void registerPixelRequestActionClassName(String pixelRequestActionClassName) {
        this.pixelRequestActionClassName = pixelRequestActionClassName;
    }

    public void registerPixelResponseActionClassName(String pixelResponseActionClassName) {
        this.pixelResponseActionClassName = pixelResponseActionClassName;
    }

    public IBidRequestAction getBidRequestAction() throws BidderFrameworkActionException {
        if (bidRequestActionClassName == null) {
            throw new BidderFrameworkActionException("The bidRequest Action class name was not registered");
        }
        IBidRequestAction bidAction = bidRequestActionFactoryCache.get();
        if (bidAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return bidAction;
    }

    private ThreadLocal<IBidRequestAction> bidRequestActionFactoryCache = new ThreadLocal<IBidRequestAction>() {
        public synchronized IBidRequestAction initialValue() {
            try {
                return (IBidRequestAction) Class.forName(bidRequestActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The bid request action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + bidRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The bid request action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + bidRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The bid request action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + bidRequestActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized IBidRequestAction get() {
            return super.get();
        }

        public synchronized void set(IBidRequestAction value) {
            super.set(value);
        }
    };
    
    public IBidResponseAction getBidResponseAction() throws BidderFrameworkActionException {
        if (bidResponseActionClassName == null) {
            throw new BidderFrameworkActionException("The bidResponse Action class name was not registered");
        }
        IBidResponseAction bidAction = bidResponseActionFactoryCache.get();
        if (bidAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return bidAction;
    }

    private ThreadLocal<IBidResponseAction> bidResponseActionFactoryCache = new ThreadLocal<IBidResponseAction>() {
        public synchronized IBidResponseAction initialValue() {
            try {
                return (IBidResponseAction) Class.forName(bidResponseActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The bid response action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + bidResponseActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The bid response action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + bidResponseActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The bid response action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + bidResponseActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized IBidResponseAction get() {
            return super.get();
        }

        public synchronized void set(IBidResponseAction value) {
            super.set(value);
        }
    };

    public IClickRequestAction getClickRequestAction() throws BidderFrameworkActionException {
        if (clickRequestActionClassName == null) {
            throw new BidderFrameworkActionException("The click Request Action class name was not registered");
        }
        IClickRequestAction clickAction = clickRequestActionFactoryCache.get();
        if (clickAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return clickAction;
    }

    private ThreadLocal<IClickRequestAction> clickRequestActionFactoryCache = new ThreadLocal<IClickRequestAction>() {
        public synchronized IClickRequestAction initialValue() {
            try {
                return (IClickRequestAction) Class.forName(clickRequestActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The click request action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + clickRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The click request action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + clickRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The click request action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + clickRequestActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized IClickRequestAction get() {
            return super.get();
        }

        public synchronized void set(IClickRequestAction value) {
            super.set(value);
        }
    };

    public INotifyRequestAction getNotifyRequestAction() throws BidderFrameworkActionException {
        if (notifyRequestActionClassName == null) {
            throw new BidderFrameworkActionException("The notify Request Action class name was not registered");
        }
        INotifyRequestAction notifyAction = notifyRequestActionFactoryCache.get();
        if (notifyAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return notifyAction;
    }

    private ThreadLocal<INotifyRequestAction> notifyRequestActionFactoryCache = new ThreadLocal<INotifyRequestAction>() {
        public synchronized INotifyRequestAction initialValue() {
            try {
                return (INotifyRequestAction) Class.forName(notifyRequestActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The notify request action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + notifyRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The notify request action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + notifyRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The notify request action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + notifyRequestActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized INotifyRequestAction get() {
            return super.get();
        }

        public synchronized void set(INotifyRequestAction value) {
            super.set(value);
        }
    };
    
    public IPixelRequestAction getPixelRequestAction() throws BidderFrameworkActionException {
        if (pixelRequestActionClassName == null) {
            throw new BidderFrameworkActionException("The pixel Request Action class name was not registered");
        }
        IPixelRequestAction pixelAction = pixelRequestActionFactoryCache.get();
        if (pixelAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return pixelAction;
    }

    private ThreadLocal<IPixelRequestAction> pixelRequestActionFactoryCache = new ThreadLocal<IPixelRequestAction>() {
        public synchronized IPixelRequestAction initialValue() {
            try {
                return (IPixelRequestAction) Class.forName(pixelRequestActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The pixel request action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + pixelRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The pixel request action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + pixelRequestActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The pixel request action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + pixelRequestActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized IPixelRequestAction get() {
            return super.get();
        }

        public synchronized void set(IPixelRequestAction value) {
            super.set(value);
        }
    };

    public IPixelResponseAction getPixelResponseAction() throws BidderFrameworkActionException {
        if (pixelResponseActionClassName == null) {
            throw new BidderFrameworkActionException("The pixelResponse Action class name was not registered");
        }
        IPixelResponseAction pixelAction = pixelResponseActionFactoryCache.get();
        if (pixelAction == null) {
            throw new BidderFrameworkActionException("The Action class could not be created. Please check the logs");
        }
        return pixelAction;
    }

    private ThreadLocal<IPixelResponseAction> pixelResponseActionFactoryCache = new ThreadLocal<IPixelResponseAction>() {
        public synchronized IPixelResponseAction initialValue() {
            try {
                return (IPixelResponseAction) Class.forName(pixelResponseActionClassName).newInstance();
            } catch (InstantiationException e) {
                LOG.fatal("The pixel response action class could not be created due to an instantiation exception. " +
                        "Please check the class registered. class-registered=[" + pixelResponseActionClassName + " Msg: " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOG.fatal("The pixel response action class could not be created due to an illegal access exception. " +
                        "Please check the class registered. class-registered=[" + pixelResponseActionClassName + " Msg: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOG.fatal("The pixel response action class could not be created due to an class not found exception. " +
                        "Please check the class registered. class-registered=[" + pixelResponseActionClassName + " Msg: " + e.getMessage(), e);
            }
            return null;
        }

        public synchronized IPixelResponseAction get() {
            return super.get();
        }

        public synchronized void set(IPixelResponseAction value) {
            super.set(value);
        }
    };
}
