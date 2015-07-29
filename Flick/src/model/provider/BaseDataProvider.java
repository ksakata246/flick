package model.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDataProvider {
	public static final Map<String, List<SessionDef>> grpSessionIdMap;

	static List<String> sessionIds(String sessionGroupId) {
		List<SessionDef> sessionInfo = grpSessionIdMap.get(sessionGroupId);
		List<String> rtn = new ArrayList<String>();
		for (SessionDef info : sessionInfo) {
			rtn.add(info.sessionId);
		}
		return rtn;
	}

	static String sessionId(String sessionGroupId, int index) {
		return sessionIds(sessionGroupId).get(index);
	}

	static List<String> sessionGroupIds() {
		return new ArrayList(grpSessionIdMap.keySet());
	}

	public static String getSessionGroupIdBySessionId(String sessionId) {
		for (Map.Entry<String, List<SessionDef>> entry : grpSessionIdMap
				.entrySet()) {
			for (SessionDef sessionDef : entry.getValue()) {
				if (sessionId.equals(sessionDef.sessionId)) {
					return entry.getKey();
				}
			}
		}
		return null;
	}

	static {
		grpSessionIdMap = new HashMap<String, List<SessionDef>>();
	}

	protected static SessionDef getSessionInfo(String sessionGroupId,
			String sessionId) {
		SessionDef ret = null;
		List<SessionDef> sessionInfo = grpSessionIdMap.get(sessionGroupId);
		for(SessionDef info : sessionInfo){
			if(info.sessionId.equals(sessionId)){
				ret=info;
				break;
			}
			return ret;
			}
		}
	private static SessionDef sessionInfo(String sessionId){
		this.sessionId= sessionId;
	}
	String sessionId;
	
	}

	static class SessionDef {
		public SessionDef(String sessionId) {
			this.sessionId = sessionId;
		}
		String sessionId;
	}
}