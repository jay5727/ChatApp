# ChatApp
Sample Chat App Design

<a href="https://imgflip.com/gif/2688fn"><img src="https://i.imgflip.com/2688fn.gif" title="made at imgflip.com"/></a>

This sample code contains 3 files which can be found here: 
app/src/main/java/com/example/jay/chatapp/ <br />

* ChatActivity
* ChatAdapter
* Message

## ChatActivity ##
 Responsible for loading dummy data from chat.json present inside assets folder. <br/> Source can be REST API also depending on requirement.

## ChatAdapter ##
   
**getItemViewType()** of RecyclerView.Adapter class comes in handy when u want to inflate different view for different row with same adapter.

The default implementation of this method returns 0, making the assumption of a single view type for the adapter. 
Unlike ListView adapters, types need not be contiguous. Consider using id resources to uniquely identify item view types.

    @Override 
    public int getItemViewType(int position) 
    { 
        return 0; 
    }

## Message ##
Data Source for RecyclerView. <br />	
Model class consisting of 3 private fields. 
     
    
    private String to;
    
    private String from;
    
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
